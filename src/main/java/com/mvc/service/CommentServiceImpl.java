package com.mvc.service;

import com.mvc.mapper.CommentMapper;
import com.mvc.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper mapper;

    @Override
    public List<Comment> selectByQnANum(int num) throws Exception {
        return mapper.selectByQnANum(num);
    }

    @Override
    public boolean insert(Comment comment) throws Exception {
        return mapper.insert(comment);
    }

    @Override
    public boolean delete(int num) throws Exception {
        return mapper.delete(num);
    }
}
