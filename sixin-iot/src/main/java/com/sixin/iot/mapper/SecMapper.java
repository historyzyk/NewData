package com.sixin.iot.mapper;

import com.sixin.iot.domain.Security;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 终端运转 数据层
 * 
 * @author 余新伟
 * @date 2019-12-20
 */
@Mapper
public interface SecMapper
{
    /**
     * 获取所有安防警报类型信息
     *
     * @return 结果
     */
    public List<Security> selectSecList();

}