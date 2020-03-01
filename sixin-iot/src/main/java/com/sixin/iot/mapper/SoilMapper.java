package com.sixin.iot.mapper;

import com.sixin.iot.domain.Soil;

import java.util.List;

public interface SoilMapper {
    /**
     * 土壤记录列表
     *
     * @return
     */
    List<Soil> selectSoilList(Soil soil);
    public List<Soil> selectSoilListByids(List<String> sfids);
    /**
     * 根据sid批量删除数据
     * @param sid
     */
    int deleteSoilByids(String[] sid);
    /**
     * 添加土壤信息
     * @param soil
     * @return
     */
    int insertSoil(Soil soil);
    /**
     * 根据sid选择数据
     * @param sid
     * @return
     */
    Soil selectByid(String sid);

    /**
     * 保存用户修改
     * @param soil
     * @return
     */
    int updateSoil(Soil soil);
    /**
     * 删除土壤信息
     * @param sid
     * @return
     */
    int deleteSoilByid(String sid);
}