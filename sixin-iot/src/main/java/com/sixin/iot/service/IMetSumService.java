package com.sixin.iot.service;

import com.sixin.iot.domain.MetSum;

import java.util.List;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
public interface IMetSumService {
    public List<MetSum> selectHumMet();
    public List<MetSum> selectRainMet();
    public List<MetSum> selectSeeMet();
    public List<MetSum> selectRiverMet();
}
