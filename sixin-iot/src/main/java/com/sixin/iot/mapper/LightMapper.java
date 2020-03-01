package com.sixin.iot.mapper;

import com.sixin.iot.domain.Light;

import java.util.List;

public interface LightMapper {
    /**
     * 路灯记录列表
     *
     * @return
     */
     List<Light> selectLightList(Light light);

    /**
     * 根据nid批量删除数据
     * @param nid
     */
    int deleteLightByids(String[] nid);
    /**
     * 添加路灯信息
     * @param light
     * @return
     */
    int insertLight(Light light);
    /**
     * 根据nid选择数据
     * @param nid
     * @return
     */
    Light selectByid(String nid);

    public List<Light> selectLightListByids(List<String> sfids);


    /**
     * 保存用户修改
     * @param light
     * @return
     */
    int updateLight(Light light);
    /**
     * 删除路灯信息
     * @param nid
     * @return
     */
    int deleteLightByid(String nid);

}