package com.sixin.iot.mapper;

import com.sixin.iot.domain.SoilWater;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SoilWaterMapper {
    public List<SoilWater> select();
//    地域含水量
  public List<SoilWater> selectname();


}
