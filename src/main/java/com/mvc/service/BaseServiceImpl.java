package com.mvc.service;

import com.mvc.mapper.BaseMapper;
import com.mvc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseMapper mapper;

    @Override
    public List<DealInfo> findApart(String keyword) throws Exception {
        return mapper.findApart(keyword);
    }

    @Override
    public List<DealInfo> findDong(String keyword) throws Exception {
        return mapper.findDong(keyword);
    }

    @Override
    public List<SidoCode> getSidoList() throws Exception {
        return mapper.getSidoList();
    }

    @Override
    public List<GugunCode> getGugunList(String sidoCode) throws Exception {
        sidoCode = sidoCode.substring(0, 2);
        return mapper.getGugunList(sidoCode);
    }

    @Override
    public List<DongCode> getDongList(String gugunCode) throws Exception {
        gugunCode = gugunCode.substring(0, 5);
        return mapper.getDongList(gugunCode);
    }

    @Override
    public DealInfo getDealInfo(String aptCode) throws Exception {
        return mapper.getDealInfo(aptCode);
    }

    @Override
    public List<DealInfos> getDealInfos(String aptCode) {
        return mapper.getDealInfos(aptCode);
    }


}
