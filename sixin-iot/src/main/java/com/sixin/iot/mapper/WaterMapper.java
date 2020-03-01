package com.sixin.iot.mapper;

import com.sixin.iot.domain.Water;

import java.util.List;

public interface WaterMapper {
    /**
     * 水质记录列表
     *
     * @return
     */
    List<Water> selectWaterList(Water water);
    public List<Water> selectWaterListByids(List<String> sfids);
    /**
     * 根据wid批量删除数据
     * @param wid
     */
    int deleteWaterByids(String[] wid);
    /**
     * 添加水质信息
     * @param water
     * @return
     */
    int insertWater(Water water);
    /**
     * 根据wid选择数据
     * @param wid
     * @return
     */
    Water selectByid(String wid);

    /**
     * 保存用户修改
     * @param water
     * @return
     */
    int updateWater(Water water);
    /**
     * 删除水质信息
     * @param wid
     * @return
     */
    int deleteWaterByid(String wid);
}
