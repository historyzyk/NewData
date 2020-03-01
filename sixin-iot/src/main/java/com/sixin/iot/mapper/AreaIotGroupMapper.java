package com.sixin.iot.mapper;

import com.sixin.iot.domain.AreaIotGroup;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */

public interface AreaIotGroupMapper {

    /**
     * 查询分组列表，连表查询
     *
     * @return 终端分组列表
     */
    public List<AreaIotGroup> listAreaIotGroup(AreaIotGroup areaIotGroup);

    /**
     * 查询分组列表
     *
     * @return 终端分组列表
     */
    public AreaIotGroup selectAreaGroupingByAid(String aid);
}
