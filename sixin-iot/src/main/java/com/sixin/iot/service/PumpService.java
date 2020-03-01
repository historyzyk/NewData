package com.sixin.iot.service;
import com.sixin.iot.domain.Pump;

import java.util.List;

/**
 * @program: PumpSys
 * @description: 水泵系统
 * @author: 饶泽敏
 * @create: 2019-12-25 15:00
 **/
public interface PumpService {
    /**
     * 查询水泵记录列表
     *
     * @return
     */
    public List<Pump> selectPumpList(Pump pump);

    /**
     * 根据id批量删除数据
     * @param id
     */
    public int deletePumpByids(String id);

    /**
     * 添加水泵公告数据
     * @param  Pump
     * @return
     */
    public int insertPump(Pump pump);
    /**
     * 根据id选择数据
     * @param id
     * @return
     */

    public Pump selectByid(String id);

    public List<Pump> selectPumpListByids(List<String> sfids);
    /*public List<Organization> selectOrganizationListByids(List<String> sfids);*/
    /**
     * 保存用户修改
     * @param Pump
     * @return
     */
    public int updatePump(Pump pump);
    /**
     * 删除水泵信息
     * @param id
     * @return
     */
    public int deletePumpByid(String id);
}
