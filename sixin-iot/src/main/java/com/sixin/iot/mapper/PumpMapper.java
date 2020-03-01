package com.sixin.iot.mapper;

import com.sixin.iot.domain.Pump;
import java.util.List;

public interface PumpMapper {
    /**
     * 水泵记录列表
     *
     * @return
     */
    List<Pump> selectPumpList(Pump pump);

    /**
     * 根据id批量删除数据
     * @param id
     */
    int deletePumpByids(String[] id);
    /**
     * 添加水泵信息
     * @param pump
     * @return
     */
    int insertPump(Pump pump);
    /**
     * 根据id选择数据
     * @param id
     * @return
     */
    Pump selectByid(String id);


    public List<Pump> selectPumpListByids(List<String> sfids);


    /**
     * 保存用户修改
     * @param pump
     * @return
     */
    int updatePump(Pump pump);
    /**
     * 删除水泵信息
     * @param id
     * @return
     */
    int deletePumpByid(String id);
}