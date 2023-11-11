package com.mvc.controller;

import com.mvc.service.QnAService;
import com.mvc.vo.QnA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class QnAController {
    @Autowired
    QnAService service;

    @GetMapping("qna")
    public ResponseEntity<List<QnA>> selectAll() {
        try {
            List<QnA> list = service.selectAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("qna/user/{id}")
    public ResponseEntity<List<QnA>> selectUser(@PathVariable String id) {
        try {
            System.out.println(id);
            List<QnA> list = service.selectUser(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("qna/{num}")
    public ResponseEntity<QnA> selectOne(@PathVariable int num) {
        try {
            QnA qna = service.selectOne(num);
            return new ResponseEntity<>(qna, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("qna")
    public ResponseEntity<Void> update(@RequestBody QnA qna) {
        try {
            System.out.println(qna.getTitle() + " " + qna.getContent());
            Integer ret = service.update(qna);
            if (ret == 0) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("qna")
    public ResponseEntity<Void> insert(@RequestBody QnA qna) {
        try {
            boolean ret = service.insert(qna);
            if (!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("qna/{num}")
    public ResponseEntity<Void> delete(@PathVariable int num) {
        try {
            boolean ret = service.delete(num);
            if (!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("qna/done")
    public ResponseEntity<Void> complete(@RequestBody QnA qna) {
        try {
            boolean ret = service.complete(qna);
            if (!ret) throw new Exception();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
