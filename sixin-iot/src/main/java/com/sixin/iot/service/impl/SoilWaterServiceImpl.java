package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.SoilWater;
import com.sixin.iot.mapper.SoilWaterMapper;
import com.sixin.iot.service.SoilWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class SoilWaterServiceImpl  implements SoilWaterService {
    @Autowired
    private SoilWaterMapper soilWaterMapper;

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<SoilWater>select(){
        return soilWaterMapper.select();
    }
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<SoilWater>selectname(){
        return  soilWaterMapper.selectname();
    }

}
