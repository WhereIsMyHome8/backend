package com.mvc.controller;

import com.mvc.service.NoticeService;
import com.mvc.vo.Notice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@CrossOrigin("*")
@RestController
public class NoticeController {
    @Autowired
    NoticeService service;

    @PostMapping("notice")
    @ApiOperation(value = "공지사항 등록", notes = "공지사항 등록하기")
    @ApiResponses({@ApiResponse(code = 200, message = "공지사항 등록 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청, 등록 실패")})
    public ResponseEntity<Void> insert(@RequestBody Notice no) {
        try {
            service.insert(no);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("notice")
    @ApiOperation(value = "공지사항 수정", notes = "공지사항 수정하기")
    @ApiResponses({@ApiResponse(code = 200, message = "공지사항 수정 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청, 수정 실패")})
    public ResponseEntity<Void> update(@RequestBody Notice no) {
        try {
            service.update(no);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("notice/{num}")
    @ApiOperation(value = "공지사항 삭제", notes = "공지사항 삭제하기")
    @ApiResponses({@ApiResponse(code = 200, message = "공지사항 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 요청, 삭제 실패")})
    public ResponseEntity<Void> delete(@PathVariable String num) {
        try {
            service.delete(num);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("notice/{num}")
    @ApiOperation(value = "공지사항 보기", notes = "공지사항 보기")
    @ApiResponses({@ApiResponse(code = 200, message = "공지사항 보기 성공"), @ApiResponse(code = 204, message = "없음"),
            @ApiResponse(code = 400, message = "잘못된 요청, 삭제 실패")})
    public ResponseEntity<Notice> selectOne(@PathVariable String num) {
        try {
            Notice notice = service.selectOne(num);
            if (notice == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(notice,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }





    @GetMapping("notice/search")
    @ApiOperation(value = "공지사항 전체검색", notes = "공지사항 전체검색")
    @ApiResponses({@ApiResponse(code = 200, message = "공지사항 리스트 가져오기 성공"), @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<List<Notice>> selectAll() {
        try {
            return new ResponseEntity<>(service.selectAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("notice/{type}/{value}}")
    @ApiOperation(value = "공지사항 부분검색", notes = "공지사항 부분검색")
    @ApiResponses({@ApiResponse(code = 200, message = "공지사항 부분 검색 성공"), @ApiResponse(code = 204, message = "결과 없음"),
            @ApiResponse(code = 401, message = "잘못된 요청, 가져오기 실패")})
    public ResponseEntity<List<Notice>> selectOne(@PathVariable String type, @PathVariable String value) {
        try {
            List<Notice> list = null;
            if (type.equals("content")) {
                list = service.selectContent(value);
            } else if (type.equals("title")) {
                list = service.selectTitle(value);
            } else {
                throw new Exception();
            }
            if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}

