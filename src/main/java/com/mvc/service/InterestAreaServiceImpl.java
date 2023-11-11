package com.mvc.service;

import com.mvc.mapper.InterestAreaMapper;
import com.mvc.vo.InterestArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestAreaServiceImpl implements InterestAreaService {
    @Autowired
    InterestAreaMapper mapper;

    @Override
    public boolean delete(String id) throws Exception {
        return mapper.delete(id);
    }

    @Override
    public boolean deleteOne(InterestArea area) throws Exception {
        return mapper.deleteOne(area);
    }


    @Override
    public boolean insert(InterestArea area) throws Exception {
        return mapper.insert(area);
    }


    @Override
    public List<InterestArea> show(String id) throws Exception {
        return mapper.show(id);
    }
}

