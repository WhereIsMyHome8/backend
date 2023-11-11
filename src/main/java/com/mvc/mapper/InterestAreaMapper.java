package com.mvc.mapper;

import com.mvc.vo.InterestArea;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface InterestAreaMapper {
    boolean insert(InterestArea area) throws SQLException;
    boolean deleteOne(InterestArea area) throws SQLException;

    List<InterestArea> show(String id) throws SQLException;

    boolean delete(String id) throws SQLException;
}
