package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.IotMessage;
import com.sixin.iot.mapper.IotMessageMapper;
import com.sixin.iot.service.IIotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Service
public class IotMessageSerivceImpl implements IIotMessageService {
    @Autowired
    IotMessageMapper iotMessageMapper;

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Map<String, Object>>  selectiotMessageList(IotMessage iotMessage) {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        List<IotMessage> areaList = iotMessageMapper.selectiotMessageList(iotMessage);
        trees = getTrees(areaList);
        return trees;
    }


    public List<Map<String, Object>> getTrees(List<IotMessage> iotMessages)
    {

        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (IotMessage iotMessage: iotMessages)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", iotMessage.getAid());
            map.put("aid", iotMessage.getAid());
            map.put("pId", iotMessage.getParentaid());
            map.put("name", iotMessage.getAname());
            map.put("phone", iotMessage.getPhone());
            trees.add(map);
        }
        return trees;
    }
}
