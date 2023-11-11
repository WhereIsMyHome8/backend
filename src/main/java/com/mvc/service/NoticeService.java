package com.mvc.service;

import com.mvc.vo.Notice;

import java.util.List;

public interface NoticeService {
    boolean insert(Notice n) throws Exception;

    boolean delete(String num) throws Exception;

    boolean update(Notice n) throws Exception;

    List<Notice> selectAll() throws Exception;

    List<Notice> selectContent(String content) throws Exception;

    List<Notice> selectTitle(String title) throws Exception;

    Notice selectOne(String num) throws Exception;
}
