package com.sixin.iot.mapper;

import com.sixin.iot.domain.Trigger;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TriggerMapper {
    public List<Trigger> selectlist();
}
