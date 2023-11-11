package com.mvc.controller;


import com.mvc.service.NoticeCommentService;
import com.mvc.vo.Notice_Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class NoticeCommentController {
    @Autowired
    NoticeCommentService service;

    @GetMapping("noticecomment/{noticeNum}")
    public ResponseEntity<List<Notice_Comment>> selectByNoticeNum(@PathVariable int noticeNum) {
        try {
            List<Notice_Comment> list = service.selectByNoticeNum(noticeNum);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("noticecomment")
    public ResponseEntity<Void> insert(@RequestBody Notice_Comment notice_comment) {
        try {
            boolean ret = service.insert(notice_comment);
            if(!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("noticecomment/{qnaNum}")
    public ResponseEntity<Void> insert(@PathVariable int noticeNum) {
        try {
            boolean ret = service.delete(noticeNum);
            if(!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
