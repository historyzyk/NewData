package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.Tersga1;
import com.sixin.iot.mapper.Soil3DMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class Soil3DServiceImpl {
    @Autowired
    private Soil3DMapper soil3D;

    @DataSource(value = DataSourceType.SXINFOM)
    public Tersga1 sumters(){
        return soil3D.sumters();
    }

    @DataSource(value = DataSourceType.SXINFOM)
    public List<Tersga1> sumterm(){
        return soil3D.sumterm();
    }
}
