package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.MetCount;
import com.sixin.iot.mapper.MetMapper;
import com.sixin.iot.service.IMetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
@Service
public class MetService implements IMetService {
    @Autowired
    private MetMapper metMapper;

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<MetCount> selectMet(){
        return metMapper.selectMet();
    }
}
