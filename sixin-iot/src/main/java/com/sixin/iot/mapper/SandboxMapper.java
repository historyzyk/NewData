package com.sixin.iot.mapper;

import com.sixin.iot.domain.Sandbox;

import java.util.List;

public interface SandboxMapper {
    /**
     * 沙盘记录列表
     *
     * @return
     */
    List<Sandbox> selectSandboxList(Sandbox sandbox);

    /**
     * 根据switch_id批量删除数据
     * @param switch_id
     */
    int deleteSandboxByids(String[] switch_id);
    /**
     * 添加沙盘信息
     * @param sandbox
     * @return
     */
    int insertSandbox(Sandbox sandbox);
    /**
     * 根据switch_id选择数据
     * @param switch_id
     * @return
     */
    Sandbox selectByid(String switch_id);

    /**
     * 保存用户修改
     * @param sandbox
     * @return
     */
    int updateSandbox(Sandbox sandbox);
    /**
     * 删除沙盘信息
     * @param switch_id
     * @return
     */
    int deleteSandboxByid(String switch_id);
}