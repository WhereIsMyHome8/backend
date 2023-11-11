package com.mvc.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvc.service.InterestAreaService;
import com.mvc.vo.InterestArea;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api
@CrossOrigin("*")
@RestController
public class InterestAreaController {
    @Autowired
    InterestAreaService service;

    @PostMapping("interest")
    @ApiOperation(value = "관심지역 등록", notes = "유저 아이디로 관심지역 등록")
    @ApiResponses({@ApiResponse(code = 200, message = "관심지역 등록 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<Void> insert(@RequestBody InterestArea interestArea) {
        try {
            if (!service.insert(interestArea)) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("interest/{id}")
    @ApiOperation(value = "관심지역 리스트", notes = "유저의 전체 관심지역 리스트 가져오기")
    @ApiResponses({@ApiResponse(code = 200, message = "관심지역 리스트 가져오기 성공"), @ApiResponse(code = 204, message = "결과 없음"),
            @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<List<InterestArea>> show(@PathVariable String id) {
        try {
            List<InterestArea> list = service.show(id);
            if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("interest/{id}")
    @ApiOperation(value = "관심지역 삭제", notes = "유저 관심지역 삭제")
    @ApiResponses({@ApiResponse(code = 200, message = "관심지역 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청, 삭제 실패")})
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("interest/deleteone")

    @ApiOperation(value = "관심지역 삭제", notes = "유저 관심지역 삭제")
    @ApiResponses({@ApiResponse(code = 200, message = "관심지역 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청, 삭제 실패")})
    public ResponseEntity<Void> delete(@RequestBody InterestArea in) {
        System.out.println("여기야삭제");
        System.out.println(in.toString());
        try {
            service.deleteOne(in);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
