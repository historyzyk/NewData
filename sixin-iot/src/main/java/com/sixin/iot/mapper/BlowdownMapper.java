package com.sixin.iot.mapper;

import com.sixin.iot.domain.Blowdown;

import java.util.List;

public interface BlowdownMapper {
    /**
     * 排污检测记录列表
     *
     * @return
     */
    public List<Blowdown> selectBlowdownList(Blowdown blowdown);
    /**
     * 添加排污检测信息
     * @param blowdown
     * @return
     */
    public int insertBlowdown(Blowdown blowdown);
    /**
     * 根据pid选择数据
     * @param pid
     * @return
     */
    public Blowdown selectByid(String pid);

    /**
     * 保存用户修改
     * @param blowdown
     * @return
     */
    public int updateBlowdown(Blowdown blowdown);
    /**
     * 删除排污检测信息
     * @param pid
     * @return
     */
    public int deleteBlowdownByid(String pid);
    /**
     * 根据pid批量删除数据
     * @param pids
     */
    public int deleteBlowdownByids(String[] pids);
}