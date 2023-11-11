package com.mvc.service;

import java.util.HashMap;
import java.util.Map;
import com.mvc.mapper.UserMapper;
import com.mvc.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public boolean check(User user) throws Exception {
        return mapper.check(user);
    }


    @Override
    public boolean checkemail(User user) throws Exception {
        return mapper.checkemail(user);
    }

    @Override
    public boolean update(User user) throws Exception {
        return mapper.update(user);
    }

    public boolean updatepass(User user) throws Exception {
        return mapper.updatepass(user);
    }

    @Override
    public boolean signUp(User user) throws Exception {
        return mapper.signUp(user);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return mapper.delete(id);
    }

    @Override
    public List<User> selectAll() throws Exception {
        return mapper.selectAll();
    }

    @Override
    public List<User> selectId(String id) throws Exception {
        return mapper.selectId(id);
    }

    @Override
    public List<User> selectName(String name) throws Exception {
        return mapper.selectName(name);
    }

    @Override
    public User selectOne(String id) throws Exception {
        return mapper.selectOne(id);
    }

    @Override
    public void saveRefreshToken(String id, String refreshToken) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("token", refreshToken);
        //sqlSession.getMapper(MemberMapper.class).saveRefreshToken(map);
        mapper.saveRefreshToken(map);
    }

    @Override
    public Object getRefreshToken(String id) throws Exception {
        //return sqlSession.getMapper(MemberMapper.class).getRefreshToken(id);
    	return mapper.getRefreshToken(id);
    }

    @Override
    public void deleRefreshToken(String id) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("token", null);
        //sqlSession.getMapper(MemberMapper.class).deleteRefreshToken(map);
        mapper.deleteRefreshToken(map);

    }
}

