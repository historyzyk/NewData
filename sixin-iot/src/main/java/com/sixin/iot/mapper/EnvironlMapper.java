package com.sixin.iot.mapper;

import com.sixin.iot.domain.Environl;

import java.util.List;

public interface EnvironlMapper {
    /**
     * 环境终端检测记录列表
     *
     * @return
     */
    public List<Environl> selectEnvironlList(Environl environl);
    /**
     * 添加环境终端检测信息
     * @param environl
     * @return
     */
    public int insertEnvironl(Environl environl);
    /**
     * 根据hid选择数据
     * @param hid
     * @return
     */
    public Environl selectByid(String hid);

    /**
     * 保存用户修改
     * @param environl
     * @return
     */
    public int updateEnvironl(Environl environl);
    /**
     * 删除环境终端检测信息
     * @param hid
     * @return
     */
    public int deleteEnvironlByid(String hid);
    /**
     * 根据hid批量删除数据
     * @param hids
     */
    public int deleteEnvironlByids(String[] hids);
}