package com.mvc.service;

import com.mvc.vo.InterestArea;

import java.util.List;

public interface InterestAreaService {
    boolean insert(InterestArea area) throws Exception;

    boolean delete(String id) throws Exception;

    boolean deleteOne(InterestArea area) throws Exception;

    List<InterestArea> show(String id) throws Exception;
}
