package com.sixin.iot.mapper;

import com.sixin.iot.domain.IotMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Repository
public interface IotMessageMapper {
    public List<IotMessage> selectiotMessageList(IotMessage iotMessage);
}
