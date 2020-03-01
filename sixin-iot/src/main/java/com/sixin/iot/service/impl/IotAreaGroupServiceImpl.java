package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.AreaIotGroup;
import com.sixin.iot.mapper.AreaIotGroupMapper;
import com.sixin.iot.service.IIotAreaGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Service
public class IotAreaGroupServiceImpl implements IIotAreaGroupService {
    /**
     * 查询分组列表，连表查询
     *
     * @return 终端分组列表
     */
    @Autowired
    private AreaIotGroupMapper areaIotGroupMapper;

    @Override
    public List<AreaIotGroup> listAreaIotGroup(AreaIotGroup areaIotGroup)
    {
        return areaIotGroupMapper.listAreaIotGroup(areaIotGroup);
    }


    /**
     * 插入分组列表
     *
     * @return 终端分组列表
     */
    @Override
    public AreaIotGroup selectAreaGroupingByAid(String aid)
    {
        return areaIotGroupMapper.selectAreaGroupingByAid(aid);
    }
}
