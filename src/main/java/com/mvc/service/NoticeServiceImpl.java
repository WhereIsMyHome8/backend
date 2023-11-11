package com.mvc.service;

import com.mvc.mapper.NoticeMapper;
import com.mvc.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    NoticeMapper mapper;

    @Override
    public boolean insert(Notice n) throws Exception {
        return mapper.insert(n);
    }

    @Override
    public boolean delete(String num) throws Exception {
        return mapper.delete(num);
    }

    @Override
    public boolean update(Notice n) throws Exception {
        return mapper.update(n);
    }

    @Override
    public List<Notice> selectAll() throws Exception {
        return mapper.selectAll();
    }

    @Override
    public List<Notice> selectContent(String content) throws Exception {
        return mapper.selectContent(content);
    }

    @Override
    public List<Notice> selectTitle(String title) throws Exception {
        return mapper.selectTitle(title);
    }

    @Override
    public Notice selectOne(String num) throws Exception {
        mapper.countUp(num);
        return mapper.selectOne(num);
    }
}
