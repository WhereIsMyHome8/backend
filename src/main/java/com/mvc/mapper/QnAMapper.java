package com.mvc.mapper;

import com.mvc.vo.QnA;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface QnAMapper {
    List<QnA> selectAll() throws SQLException;

    List<QnA> selectUser(String id) throws SQLException;

    QnA selectOne(int num) throws SQLException;

    Integer update(QnA qna) throws SQLException;

    boolean insert(QnA qna) throws SQLException;

    boolean delete(int num) throws SQLException;

    void countUp(int num) throws SQLException;

    boolean complete(QnA qna) throws SQLException;
}
