package com.sixin.iot.service;
import com.sixin.iot.domain.Environl;

import java.util.List;


public interface EnvironlService {
    /**
     * 查询环境记录列表
     *
     * @return
     */
    public List<Environl> selectEnvironlList(Environl environl);
    /**
     * 添加环境公告数据
     *
     */
    public int insertEnvironl(Environl environl);
    /**
     * 根据hid选择数据
     *
     */
    public Environl selectByid(String hid);
    /**
     * 保存用户修改
     *
     */
    public int updateEnvironl(Environl environl);
    /**
     * 删除环境信息
     *
     */
    public int deleteEnvironlByid(String hid);

    /**
     * 根据hid批量删除数据
     *
     */
    public int deleteEnvironlByids(String ids);

}