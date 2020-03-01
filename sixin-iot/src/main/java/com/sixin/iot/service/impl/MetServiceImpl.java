package com.sixin.iot.service.impl;

import com.sixin.iot.mapper.MetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Service
public class MetServiceImpl {
    @Autowired
    private MetMapper metMapper;

//    @Override
//    @DataSource(value = DataSourceType.SXIOT)
//    public List<Met> selectMetList(){
//        return metMapper.selectMetList();
//    }
}
