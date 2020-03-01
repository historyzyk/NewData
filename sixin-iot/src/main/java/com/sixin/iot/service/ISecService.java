package com.sixin.iot.service;

import com.sixin.iot.domain.Security;

import java.util.List;

/**
 * 终端运转 服务层
 * 
 * @author 余新伟
 * @date 2020-12-20
 */
public interface ISecService
{
    /**
     * 查询安防警报类型集合
     *
     * @param
     * @return 安防警报类型集合
     */
    public List<Security> selectSecList();


}
