package com.mvc.mapper;

import com.mvc.vo.Notice_Comment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface NoticeCommentMapper {
    List<Notice_Comment> selectByNoticeNum(int num) throws SQLException;
    boolean insert(Notice_Comment comment) throws SQLException;
    boolean delete(int num) throws SQLException;
}
