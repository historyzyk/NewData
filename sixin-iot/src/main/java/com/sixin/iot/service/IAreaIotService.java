package com.sixin.iot.service;

import com.sixin.iot.domain.AreaIot;

import java.util.List;
import java.util.Map;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
public interface IAreaIotService {
    /**
     * 查询终端地域列表
     *
     * @param AreaIot 终端地域信息
     * @return 终端地域集合
     */
    public List<AreaIot> selectAreaList(AreaIot areaIot);

    /**
     * 查询终端地区树
     *
     * @param AreaIot 部门信息
     * @return 所有部门信息
     */
    public List<Map<String, Object>> selectAreaTree(AreaIot areaIot);

    /**
     * 通过aid查询终端地域列表
     *
     * @param AreaIot 终端地域信息
     * @return 终端地域集合
     */
    public List<AreaIot> chooseAreaList(AreaIot areaIot);
    /**
     * 查询终端地域信息
     *
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
    public AreaIot selectAreaIotById(String aid);
}
