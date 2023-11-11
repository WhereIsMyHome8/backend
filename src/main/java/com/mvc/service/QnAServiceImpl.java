package com.mvc.service;

import com.mvc.mapper.QnAMapper;
import com.mvc.vo.QnA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class QnAServiceImpl implements QnAService{
    @Autowired
    QnAMapper mapper;

    @Override
    public List<QnA> selectAll() throws Exception {
        return mapper.selectAll();
    }

    @Override
    public QnA selectOne(int num) throws Exception {
        mapper.countUp(num);
        return mapper.selectOne(num);
    }

    @Override
    public List<QnA> selectUser(String id) throws Exception {
        return mapper.selectUser(id);
    }


    @Override
    public Integer update(QnA qna) throws Exception {
        return mapper.update(qna);
    }

    @Override
    public boolean insert(QnA qna) throws Exception {
        return mapper.insert(qna);
    }

    @Override
    public boolean delete(int num) throws Exception {
        return mapper.delete(num);
    }

    @Override
    public boolean complete(QnA qna) throws Exception {
        return mapper.complete(qna);
    }
}
