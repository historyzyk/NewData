package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.Watertem;
import com.sixin.iot.mapper.WatertemMapper;
import com.sixin.iot.service.IWatertemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterServiceImpl implements IWatertemService {

    @Autowired
    private WatertemMapper watertemMapper;
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Watertem> selecttem()
    {
        return watertemMapper.selecttem();
    }
}
