package com.sixin.iot.service;

import com.sixin.iot.domain.MetFind;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
public interface IMetFindService {
    public List<Map<String,Object>> selectfindMet(@Param("id") String id);
    public List<Map<String,Object>> selectfindnameMet(@Param("rname") String rname);
    public List<Map<String,Object>> deleteidMet(@Param("id") String id);
}
