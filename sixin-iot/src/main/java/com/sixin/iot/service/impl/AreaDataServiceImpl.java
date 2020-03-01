package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.RiverData;
import com.sixin.iot.mapper.RiverDataMapper;
import com.sixin.iot.service.IAreaDataService;
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
public class AreaDataServiceImpl implements IAreaDataService {
    @Autowired
    private RiverDataMapper riverDataMapper;

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<RiverData> selectData(){
        return riverDataMapper.selectData();
    }
}
