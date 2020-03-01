package com.sixin.iot.service.impl;
import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Sandbox;
import com.sixin.iot.mapper.SandboxMapper;
import com.sixin.iot.service.SandboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:  SandboxSys
 * @description: 沙盘系统
 * @author: 饶泽敏
 * @create: 2019-12-25 15:10
 **/
@Service
public class SandboxServiceImpl implements SandboxService{
    @Autowired
    private SandboxMapper SandboxMapper;

    /**
     * 查询沙盘记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Sandbox> selectSandboxList(Sandbox Sandbox) {
        return SandboxMapper.selectSandboxList(Sandbox);
    }

    /**
     * 根据id批量删除数据
     * @param id
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteSandboxByids(String switch_id) {
        return SandboxMapper.deleteSandboxByids(Convert.toStrArray(switch_id));
    }

    /**
     * 添加沙盘公告数据
     * @param  Sandbox
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertSandbox(Sandbox sandbox) {
        return SandboxMapper.insertSandbox(sandbox);
    }

    /**
     * 根据switch_id选择数据
     * @param switch_id
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Sandbox selectByid(String switch_id) {
        return SandboxMapper.selectByid(switch_id);
    }

    /**
     * 删除沙盘信息
     * @param Sandbox
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteSandboxByid(String switch_id) {
        return SandboxMapper.deleteSandboxByid(switch_id);
    }

    /**
     * 保存用户修改
     * @param Sandbox
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateSandbox(Sandbox Sandbox) {
        return SandboxMapper.updateSandbox(Sandbox);
    }

}
