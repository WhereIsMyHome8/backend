package com.mvc.controller;


import com.mvc.service.JwtServiceImpl;
import com.mvc.service.MailService;
import com.mvc.service.UserService;
import com.mvc.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api

@CrossOrigin("*")

@RestController

public class UserController {
    @Autowired
    UserService service;
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    @Autowired
    private JwtServiceImpl jwtService;
    @Autowired
    private MailService mailService;

    @PostMapping("user")
    @ApiOperation(value = "로그인", notes = "아이디 비밀번호로 로그인")
    @ApiResponses({@ApiResponse(code = 200, message = "로그인 성공"), @ApiResponse(code = 400, message = "잘못된 요청, 로그인 실패")})
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            boolean t = service.check(user);
            if (t) {
                String accessToken = jwtService.createAccessToken("id", user.getId());// key, data
                String refreshToken = jwtService.createRefreshToken("id", user.getId());// key, data
                service.saveRefreshToken(user.getId(), refreshToken);
                logger.debug("로그인 accessToken 정보 : {}", accessToken);
                logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
                System.out.println("로그인성공");
                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                System.out.println("로그인실패");
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("로그인실패");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }


    @GetMapping("user/{id}")
    @ApiOperation(value = "로그아웃", notes = "로그아웃")
    @ApiResponses({@ApiResponse(code = 200, message = "로그아웃 성공"), @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<?> logout(@PathVariable String id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            service.deleRefreshToken(id);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody User user, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refresh-token");
        logger.debug("token : {}, memberDto : {}", token, user);
        if (jwtService.checkToken(token)) {
            if (token.equals(service.getRefreshToken(user.getId()))) {
                String accessToken = jwtService.createAccessToken("id", user.getId());
                logger.debug("token : {}", accessToken);
                logger.debug("정상적으로 액세스토큰 재발급!!!");
                resultMap.put("access-token", accessToken);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            }
        } else {
            logger.debug("리프레쉬토큰도 사용불!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("user/inform/{id}")
    @ApiOperation(value = "특정회원", notes = "특정회원")
    @ApiResponses({@ApiResponse(code = 200, message = "특정 회원보여주기 성공"), @ApiResponse(code = 400, message = "잘못된 요청"),
            @ApiResponse(code = 401, message = "권한 없음")})
    public ResponseEntity<Map<String, Object>> getInfo(@PathVariable String id, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        if (jwtService.checkToken(request.getHeader("access-token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                //				로그인 사용자 정보.
                User user = service.selectOne(id);
                resultMap.put("userInfo", user);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }


    @PutMapping("user")
    @ApiOperation(value = "회원 정보 수정", notes = "회원 정보 수정")
    @ApiResponses({@ApiResponse(code = 200, message = "회원 정보 수정 성공"), @ApiResponse(code = 400, message = "잘못된 요청"), @ApiResponse(code = 401, message = "권한 없음")})
    public ResponseEntity<Void> userUpdate(@RequestBody User user) {

        String id = user.getId();

        try {
            if (!service.update(user)) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴")
    @ApiResponses({@ApiResponse(code = 200, message = "회원 탈퇴 성공"), @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {
            if (id == null) throw new Exception();
            if (!service.delete(id)) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("user/new")
    @ApiOperation(value = "회원 가입", notes = "회원 가입")
    @ApiResponses({@ApiResponse(code = 200, message = "회원 가입 성공"), @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<Void> signUp(@RequestBody User user) {
        System.out.println("아 응애에요~~ 회원가입 들어옴 ");
        System.out.println(user.toString());
        try {
            if (!service.signUp(user)) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "이메일 인증코드 전송", notes = "전송한 인증코드를 반환한다.", response = Map.class)
    @PostMapping("user/sendmail")
    public ResponseEntity<Map<String, Object>> sendMail(@RequestBody User user) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        //우선 id와 email이 있는지 파악을 해야 하고 그 후에 다시 전송을 해야 함
        try {
            boolean checkUser = service.checkemail(user);
            System.out.println(checkUser);
            if (!checkUser)//해당 되는 아이디와 이메일을 잘못 기입을 한 상태를 의미함
            {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String code = mailService.sendMail("findPw", user.getEmail());
        if (code.equals("error")) {
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        } else {
            resultMap.put("message", SUCCESS);
            resultMap.put("code", code);
            status = HttpStatus.ACCEPTED;
            System.out.println(code);
            user.setPass(code);
            try {
                service.updatepass(user);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("user/inform/all")
    @ApiOperation(value = "특정회원", notes = "특정회원")
    @ApiResponses({@ApiResponse(code = 200, message = "전체회원보여주기 성공"), @ApiResponse(code = 400, message = "잘못된 요청"),
            @ApiResponse(code = 401, message = "권한 없음")})
    public ResponseEntity<List<User>> show_user_all() {
        try {
//            if (name.equals("admin")) { // 특정회원 볼수 있는 코드를 의미함
//                // service.~~
//                List<User> t = service.selectAll();
//                return new ResponseEntity<>(t, HttpStatus.OK);
//            } else {
//
//                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//
//            }

            List<User> t = service.selectAll();
            return new ResponseEntity<>(t, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("user/inform/{type}/{parameter}")
    @ApiOperation(value = "특정회원", notes = "특정회원")
    @ApiResponses({@ApiResponse(code = 200, message = "전체회원보여주기 성공"), @ApiResponse(code = 400, message = "잘못된 요청"),
            @ApiResponse(code = 401, message = "권한 없음")})
    public ResponseEntity<List<User>> search_user(@PathVariable String type, @PathVariable String parameter) {
        System.out.println("search_user");
        System.out.println(type);
        System.out.println(parameter);
        try {
            //아이디  혹은 이름으로 검색이 되게 하자
            List<User> t = null;
            if (type.equals("id")) {
                t = service.selectId(parameter);
            } else if (type.equals("name")) {
                t = service.selectName(parameter);
            }
            for (User a : t) {
                System.out.println(a.getId());
            }
            return new ResponseEntity<>(t, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @RequestMapping(value = "/kakao", method = {RequestMethod.GET})
    @ResponseBody
    public String kakaologin() {
        System.out.println("카카오로그인들어옴");
        String key = "0cf8418afcea2d97276c282d6859cb2f";
        String url = "https://kauth.kakao.com/oauth/authorize?client_id=25abd73010194d66da5351385689ddc4&redirect_uri=http://localhost:8080/login/kakao&response_type=0cf8418afcea2d97276c282d6859cb2f";
        System.out.println("login 컨트롤러 접근");
        return url;

    }


}


