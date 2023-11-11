package com.mvc.service;

import com.mvc.vo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectByQnANum(int num) throws Exception;

    boolean insert(Comment comment) throws Exception;

    boolean delete(int num) throws Exception;
}
