 package com.sixin.iot.mapper;

import com.sixin.iot.domain.Waterpannel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public  interface WaterpannelMapper {

    /**
     * 查询所有水质数据记录
     *
     * @param
     *
     */
    public List<Waterpannel> selectWaterpannelList();

    /**
     * 根据id查询水质数据信息
     *
     * @param id 水质数据ID
     * @return 水质数据信息
     */
    public  List<Map<String,Object>> selectListById(@Param("id") Integer id);




    /**
     * 删除水质数据信息
     *
     * @param  id   水质数据ID
     * @return 水质数据信息
     */

    public List<Map<String,Object>> deleteListById(Integer id);





}
