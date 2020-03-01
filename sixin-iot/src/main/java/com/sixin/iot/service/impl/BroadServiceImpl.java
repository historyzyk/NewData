package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Broad;
import com.sixin.iot.mapper.BroadMapper;
import com.sixin.iot.service.BroadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: BroadSys
 * @description: 广播系统
 * @author: 饶泽敏
 * @create: 2019-12-24 15:40
 **/
@Service
public class BroadServiceImpl implements BroadService {
    @Autowired
    private BroadMapper broadMapper;

    /**
     * 查询广播记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Broad> selectBroadList(Broad broad) {
        return broadMapper.selectBroadList(broad);
    }

    /**
     * 根据broad_id选择数据
     * @param broad_id
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Broad selectBroadByid(String broad_id) {
        return broadMapper.selectBroadByid(broad_id);
    }

    /**
     * 添加广播公告数据
     * @param  broad
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertBroad(Broad broad) {
        return broadMapper.insertBroad(broad);
    }

    /**
     * 批量删除广播信息
     * @param broad_ids
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteBroadByids(String ids) {
        return broadMapper.deleteBroadByids(Convert.toStrArray(ids));
    }


    /**
     * 根据id批量删除数据
     * @param broad_id

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteBroadByid(String broad_id) {
        return broadMapper.deleteBroadByid(broad_id);
    }
     */



    /**
     * 保存用户修改
     * @param broad
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateBroad(Broad broad) {
        return broadMapper.updateBroad(broad);
    }

}
