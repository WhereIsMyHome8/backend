package com.mvc.controller;

import com.mvc.service.BaseService;
import com.mvc.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@CrossOrigin("*")
@RestController
public class BaseController {
    @Autowired
    BaseService service;

    @GetMapping("dealinfo/{type}/{keyword}")
    @ApiOperation(value = "거래내역 가져오기", notes = "dong 또는 아파트 이름으로 아파트 거래내역 가져오기")
    @ApiResponses({@ApiResponse(code = 200, message = "거래내역 가져오기 성공"), @ApiResponse(code = 204, message = "결과 없음"),
            @ApiResponse(code = 400, message = "잘못된 요청")})
    public ResponseEntity<List<DealInfo>> getDealInfo(@PathVariable String type, @PathVariable String keyword) {
        try {
            System.out.println("type: " + type);
            System.out.println("keyword: " + keyword);
            List<DealInfo> list = null;
            if (type.equals("dong")) {
                list = service.findDong(keyword);
            } else {
                list = service.findApart(keyword);
            }
            if (list == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sido")
    public ResponseEntity<List<SidoCode>> getSidoList() {
        try {
            List<SidoCode> list = service.getSidoList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/gugun/{sidoCode}")
    public ResponseEntity<List<GugunCode>> getGugunList(@PathVariable String sidoCode) {
        try {
            List<GugunCode> list = service.getGugunList(sidoCode);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/dong/{gugunCode}")
    public ResponseEntity<List<DongCode>> getDongList(@PathVariable String gugunCode) {
        try {
            List<DongCode> list = service.getDongList(gugunCode);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/apt/{aptCode}")
    public ResponseEntity<DealInfo> getApartInfo(@PathVariable String aptCode) {
        try {
            DealInfo dealInfo = service.getDealInfo(aptCode);
            return new ResponseEntity<>(dealInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/apt/deal/{aptCode}")
    public ResponseEntity<List<DealInfos>> getApartInfos(@PathVariable String aptCode) {
        try {
            List<DealInfos> deal = service.getDealInfos(aptCode);
            System.out.println("전체 거래 내역 조회를 위한 곳");
            for (DealInfos d : deal) {
                System.out.println(d.toString());
            }
            return new ResponseEntity<>(deal, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
