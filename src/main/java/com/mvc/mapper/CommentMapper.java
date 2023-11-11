package com.mvc.mapper;

import com.mvc.vo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectByQnANum(int num) throws SQLException;
    boolean insert(Comment comment) throws SQLException;
    boolean delete(int num) throws SQLException;
}
