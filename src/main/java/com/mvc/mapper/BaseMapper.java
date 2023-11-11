package com.mvc.mapper;

import com.mvc.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseMapper {
    List<DealInfo> findDong(String parameter);

    List<DealInfo> findApart(String parameter);

    List<SidoCode> getSidoList();

    List<GugunCode> getGugunList(String sidoCode);

    List<DongCode> getDongList(String gugunCode);

    DealInfo getDealInfo(String aptCode);

    List<DealInfos> getDealInfos(String aptCode);
}
