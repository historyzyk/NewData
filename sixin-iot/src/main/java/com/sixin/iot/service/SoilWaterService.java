package com.sixin.iot.service;

import com.sixin.iot.domain.SoilWater;

import java.util.List;

public interface SoilWaterService {
    public List<SoilWater>select();
    public List<SoilWater>selectname();

}
