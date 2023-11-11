package com.mvc.controller;

import com.mvc.service.CommentService;
import com.mvc.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CommentController {
    @Autowired
    CommentService service;

    @GetMapping("comment/{qnaNum}")
    public ResponseEntity<List<Comment>> selectByQnANum(@PathVariable int qnaNum) {
        try {
            List<Comment> list = service.selectByQnANum(qnaNum);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("comment")
    public ResponseEntity<Void> insert(@RequestBody Comment comment) {
        try {
            boolean ret = service.insert(comment);
            if(!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("comment/{qnaNum}")
    public ResponseEntity<Void> insert(@PathVariable int qnaNum) {
        try {
            boolean ret = service.delete(qnaNum);
            if(!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
