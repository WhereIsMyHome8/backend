package com.mvc.service;

import com.mvc.vo.*;

import java.util.List;
import java.util.Map;

public interface BaseService {
    List<DealInfo> findApart(String keyword) throws Exception;

    List<DealInfo> findDong(String keyword) throws Exception;

    List<SidoCode> getSidoList() throws Exception;

    List<GugunCode> getGugunList(String sidoCode) throws Exception;

    List<DongCode> getDongList(String gugunCode) throws Exception;

    DealInfo getDealInfo(String aptCode) throws Exception;

    List<DealInfos> getDealInfos(String aptCode);
}
