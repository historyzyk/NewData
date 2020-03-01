package com.sixin.iot.service;

import com.sixin.iot.domain.IotMessage;

import java.util.List;
import java.util.Map;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
public interface IIotMessageService {
    public List<Map<String, Object>> selectiotMessageList (IotMessage iotMessage);
}
