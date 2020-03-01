package com.sixin.iot.mapper;

import com.sixin.iot.domain.Watertem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WatertemMapper {

    public List<Watertem> selecttem();
}
