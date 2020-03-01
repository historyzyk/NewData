package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.mapper.MetFindMapper;
import com.sixin.iot.service.IMetFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */

@Service
public class MetFindService implements IMetFindService {
    @Autowired
    private MetFindMapper metFindMapper;

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Map<String,Object>> selectfindMet(String id){
        return metFindMapper.selectfindMet(id);
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Map<String,Object>> selectfindnameMet(String rname){
        return metFindMapper.selectfindnameMet(rname);
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Map<String,Object>> deleteidMet(String id){
        return metFindMapper.deleteidMet(id);
    }
}
