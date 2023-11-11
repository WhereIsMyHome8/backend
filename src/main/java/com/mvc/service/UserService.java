package com.mvc.service;

import com.mvc.vo.User;

import java.util.List;

public interface UserService {
    boolean check(User user) throws Exception;

    boolean checkemail(User user) throws Exception;

    boolean update(User user) throws Exception;
    boolean updatepass(User user) throws Exception;

    boolean signUp(User user) throws Exception;

    boolean delete(String id) throws Exception;

    List<User> selectAll() throws Exception;

    List<User> selectId(String id) throws Exception;

    List<User> selectName(String name) throws Exception;


    User selectOne(String id) throws Exception;

    public void saveRefreshToken(String id, String refreshToken) throws Exception;
    public Object getRefreshToken(String id) throws Exception;
    public void deleRefreshToken(String id) throws Exception;



}
