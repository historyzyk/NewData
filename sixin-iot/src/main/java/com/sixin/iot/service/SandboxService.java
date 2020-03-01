package com.sixin.iot.service;
import com.sixin.iot.domain.Sandbox;

import java.util.List;

/**
 * @program: SandboxSys
 * @description: 沙盘系统
 * @author: 饶泽敏
 * @create: 2019-12-25 15:20
 **/

public interface  SandboxService {
    /**
     * 查询沙盘记录列表
     *
     * @return
     */
    public List<Sandbox> selectSandboxList(Sandbox Sandbox);

    /**
     * 根据switch_id批量删除数据
     * @param switch_id
     */
    public int deleteSandboxByids(String switch_id);

    /**
     * 添加沙盘公告数据
     * @param  Sandbox
     * @return
     */
    public int insertSandbox(Sandbox sandbox);
    /**
     * 根据switch_id选择数据
     * @param switch_id
     * @return
     */
    public Sandbox selectByid(String switch_id);
    /**
     * 保存用户修改
     * @param Sandbox
     * @return
     */
    public int updateSandbox(Sandbox Sandbox);
    /**
     * 删除沙盘信息
     * @param switch_id
     * @return
     */
    public int deleteSandboxByid(String switch_id);
}
