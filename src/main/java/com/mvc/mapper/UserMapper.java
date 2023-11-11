package com.mvc.mapper;

import com.mvc.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    boolean check(User user) throws SQLException;

    boolean checkemail(User user) throws SQLException;

    boolean update(User user) throws SQLException;
    boolean updatepass(User user) throws SQLException;


    boolean signUp(User user) throws SQLException;

    boolean delete(String id) throws SQLException;

    List<User> selectAll() throws SQLException;

    List<User> selectId(String id) throws SQLException;

    List<User> selectName(String name) throws SQLException;

    User selectOne(String id) throws SQLException;
    
    public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userid) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;

}
