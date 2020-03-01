package com.sixin.iot.service;

import com.sixin.iot.domain.EnvirData;
import com.sixin.iot.domain.RiverData;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
public interface IMilService {
    public List<EnvirData> selectMilList();
    public List<EnvirData> selectMilPm();
   // public List<RiverData> selectData(String rname);
}
