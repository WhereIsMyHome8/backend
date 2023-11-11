package com.mvc.mapper;

import com.mvc.vo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> selectAll() throws SQLException;

    List<Notice> selectContent(String content) throws SQLException;

    List<Notice> selectTitle(String title) throws SQLException;

    boolean update(Notice notice) throws SQLException;

    boolean insert(Notice notice) throws SQLException;

    boolean countUp(String num) throws SQLException;

    boolean delete(String num) throws SQLException;

    Notice selectOne(String num) throws SQLException;
}
