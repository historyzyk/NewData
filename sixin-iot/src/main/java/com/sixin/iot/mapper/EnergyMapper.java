package com.sixin.iot.mapper;

import com.sixin.iot.domain.Energy;

import java.util.List;

public interface EnergyMapper {
    /**
     * 能源管理记录列表
     *
     * @return
     */
    List<Energy> selectEnergyList(Energy energy);
    /**
     * 根据eid批量删除数据
     * @param eid
     */
    int deleteEnergyByids(String[] eid);
    /**
     * 添加能源管理记录信息
     * @param energy
     * @return
     */
    int insertEnergy(Energy energy);
    /**
     * 根据eid选择数据
     * @param eid
     * @return
     */
    Energy selectByid(String eid);


    public List<Energy> selectEnergyListByids(List<String> sfids);


    //Energy selectBybvo(String bvoltage);

    /**
     * 保存用户修改
     * @param energy
     * @return
     */
    int updateEnergy(Energy energy);
    /**
     * 删除能源管理记录信息
     * @param eid
     * @return
     */
    int deleteEnergyByid(String eid);
}