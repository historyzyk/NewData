package com.sixin.iot.mapper;

import com.sixin.iot.domain.MetCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
@Mapper
public interface MetMapper {
    public List<MetCount> selectMet();
}
