package com.sixin.iot.mapper;

import com.sixin.iot.domain.AreaIot;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
public interface AreaIotMapper {
    /**
     * 查询终端地域信息
     *
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
    public AreaIot selectAreaIotById(String aid);
    /**
     * 查询终端地域列表
     *
     * @param areaIot 终端地域信息
     * @return 终端地域集合
     */
    public List<AreaIot> selectAreaList(AreaIot areaIot);

    /**
     * 通过aid查询终端地域列表
     *
     * @param areaIot 终端地域信息
     * @return 终端地域集合
     */
    public List<AreaIot> chooseAreaList(AreaIot areaIot);
}
