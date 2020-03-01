package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.Trigger;
import com.sixin.iot.mapper.TriggerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriggerServiceImpl {
    @Autowired
    private TriggerMapper triggerMapper;
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Trigger> selectlist(){
        return triggerMapper.selectlist();
    }
}
