package com.mvc.service;
import com.mvc.vo.Notice_Comment;
import java.util.List;

public interface NoticeCommentService {
    List<Notice_Comment> selectByNoticeNum(int num) throws Exception;

    boolean insert(Notice_Comment comment) throws Exception;

    boolean delete(int num) throws Exception;
}
