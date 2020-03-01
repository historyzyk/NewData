package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Water;
import com.sixin.iot.mapper.WaterMapper;
import com.sixin.iot.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Service
public class WaterServiceImpl1 implements WaterService {
    @Autowired
    private WaterMapper waterMapper;

    /**
     * 查询水质记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Water> selectWaterList(Water water) {
        return waterMapper.selectWaterList(water);
    }

    /**
     * 根据id批量删除数据
     * @param wid
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteWaterByids(String wid) {
        return waterMapper.deleteWaterByids(Convert.toStrArray(wid));
    }

    /**
     * 添加水质公告数据
     * @param  water
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertWater(Water water) {
        return waterMapper.insertWater(water);
    }

    /**
     * 根据wid选择数据
     * @param wid
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Water selectBywid(String wid) {
        return waterMapper.selectByid(wid);
    }

    /**
     * 删除水质信息
     * @param wid
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteWaterByid(String wid) {
        return waterMapper.deleteWaterByid(wid);
    }

    /**
     * 保存用户修改
     * @param water
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateWater(Water water) {
        return waterMapper.updateWater(water);
    }
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Water> selectWaterListByids(List<String> sfids){
        return waterMapper.selectWaterListByids(sfids);
    }
}
