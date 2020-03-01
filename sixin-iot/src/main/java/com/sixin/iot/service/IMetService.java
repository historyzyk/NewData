package com.sixin.iot.service;

import com.sixin.iot.domain.MetCount;

import java.util.List;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
public interface IMetService {
    /**
     * 查询下雨信息
     */
    public List<MetCount> selectMet();
}
