package com.sixin.iot.service;
import com.sixin.iot.domain.Energy;

import java.util.List;

/**
 * @program: EnergySys
 * @description: 能源管理系统
 * @author: 饶泽敏
 * @create: 2019-12-25 14:20
 **/
public interface EnergyService {
    /**
     * 查询能源管理记录列表
     *
     * @return
     */
    public List<Energy> selectEnergyList(Energy energy);

    /**
     * 根据eid批量删除数据
     * @param id
     */
    public int deleteEnergyByids(String eid);

    /**
     * 添加能源管理公告数据
     * @param  Energy
     * @return
     */
    public int insertEnergy(Energy energy);
    /**
     * 根据eid选择数据
     * @param eid
     * @return
     */
    public Energy selectByeid(String eid);

    public List<Energy> selectEnergyListByids(List<String> sfids);

    // public Energy selectBybvo(String bcoltage);
    /**
     * 保存用户修改
     * @param Energy
     * @return
     */
    public int updateEnergy(Energy energy);
    /**
     * 删除能源管理信息
     * @param eid
     * @return
     */
    public int deleteEnergyByid(String eid);
}
