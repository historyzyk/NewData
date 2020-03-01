package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.AreaIot;
import com.sixin.iot.mapper.AreaIotMapper;
import com.sixin.iot.service.IAreaIotService;
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
public class AreaIotServiceImpl implements IAreaIotService {
    @Autowired
    private AreaIotMapper areaIotMapper;
    /**
     * 查询终端地域列表
     *
     * @param areaIot 终端地域信息
     * @return 终端地域集合
     */
    @Override
    @DataSource(value = DataSourceType.MASTER)
    public List<AreaIot> selectAreaList(AreaIot areaIot)
    {
        return areaIotMapper.selectAreaList(areaIot);
    }

    @Override
    @DataSource(value = DataSourceType.MASTER)
    public List<AreaIot> chooseAreaList(AreaIot areaIot) {
        return areaIotMapper.chooseAreaList(areaIot);
    }
    /**
     * 查询终端地区树
     * @author 申超豪
     * @date
     * @param
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    @DataSource(value = DataSourceType.MASTER)
    public List<Map<String, Object>> selectAreaTree(AreaIot areaIot){
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        List<AreaIot> areaIotList = areaIotMapper.chooseAreaList(areaIot);
        trees = getTrees(areaIotList);
        return trees;
    }


    /**
     * 根据List生产tree，前提是模型中包含id和父id关系
     * @author 申超豪
     * @date
     * @param
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> getTrees(List<AreaIot> areaIotList)
    {

        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (AreaIot areaIot : areaIotList)
        {
            Map<String, Object> areaMap = new HashMap<String, Object>();
            areaMap.put("id", areaIot.getAid());
            areaMap.put("pId", areaIot.getParentaid());
            areaMap.put("name", areaIot.getAname());
            areaMap.put("title", areaIot.getAname());
            trees.add(areaMap);
        }
        return trees;
    }

    /**
     * 查询终端地域信息
     *
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
    @Override
    @DataSource(value = DataSourceType.MASTER)
    public AreaIot selectAreaIotById(String aid)
    {
        return areaIotMapper.selectAreaIotById(aid);
    }
}
