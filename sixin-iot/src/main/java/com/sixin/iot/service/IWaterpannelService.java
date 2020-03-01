 package com.sixin.iot.service;

import com.sixin.iot.domain.Waterpannel;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IWaterpannelService {

    /**
     * 查询所有水质数据
     *


     */
    public List<Waterpannel> selectWaterpannelList();

    /**
     * 查询水质数据信息
     *
     * @param id 水质数据ID
     * @return 水质数据信息
     */
    public  List<Map<String,Object>> selectListById(@Param("id")Integer id);




   /**
    *
    * 删除水质数据信息
    * @param  id   水质数据ID
    * @return 水质数据信息
    */

    public List<Map<String,Object>> deleteListById(Integer id);







    /**
     * 新增水质监测
     *
     * @param waterpannel 水质监测信息
     * @return 结果
     */
    //public int insertWaterpannel(Waterpannel waterpannel);

}
