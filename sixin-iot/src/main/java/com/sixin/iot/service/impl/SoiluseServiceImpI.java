package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.Soilusetype;
import com.sixin.iot.mapper.SoilTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoiluseServiceImpI {
    @Autowired
    private SoilTypeMapper soilTypeMapper;

    @DataSource(value = DataSourceType.SXINFOM)
    public List<Soilusetype> select()
    {
        return soilTypeMapper.select();
    }
}
