package com.mvc.service;

import com.mvc.mapper.NoticeCommentMapper;
import com.mvc.vo.Notice_Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeCommentServiceImpl implements NoticeCommentService{
    @Autowired
    NoticeCommentMapper mapper;


    @Override
    public List<Notice_Comment> selectByNoticeNum(int num) throws Exception {
        return mapper.selectByNoticeNum(num);
    }

    @Override
    public boolean insert(Notice_Comment comment) throws Exception {
        return mapper.insert(comment);
    }

    @Override
    public boolean delete(int num) throws Exception {
        return mapper.delete(num);
    }
}
