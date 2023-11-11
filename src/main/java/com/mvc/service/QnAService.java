package com.mvc.service;

import com.mvc.vo.QnA;

import java.sql.SQLException;
import java.util.List;

public interface QnAService {
    List<QnA> selectAll() throws Exception;

    QnA selectOne(int num) throws Exception;

    List<QnA> selectUser(String id) throws Exception;

    Integer update(QnA qna) throws Exception;

    boolean insert(QnA qna) throws Exception;

    boolean delete(int num) throws Exception;

    boolean complete(QnA qna) throws Exception;

}
