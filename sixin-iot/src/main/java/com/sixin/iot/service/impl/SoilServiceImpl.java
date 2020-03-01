package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Soil;
import com.sixin.iot.mapper.SoilMapper;
import com.sixin.iot.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SoilSys
 * @description: 土壤系统
 * @author: 饶泽敏
 * @create: 2019-12-25 13:40
 **/
@Service

public class SoilServiceImpl implements SoilService {
    @Autowired
    private SoilMapper soilMapper;

    /**
     * 查询土壤记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Soil> selectSoilList(Soil soil) {
        return soilMapper.selectSoilList(soil);
    }

    /**
     * 根据id批量删除数据
     * @param sid
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteSoilByids(String sid) {
        return soilMapper.deleteSoilByids(Convert.toStrArray(sid));
    }

    /**
     * 添加土壤公告数据
     * @param  soil
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertSoil(Soil soil) {
        return soilMapper.insertSoil(soil);
    }

    /**
     * 根据sid选择数据
     * @param sid
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Soil selectBysid(String sid) {
        return soilMapper.selectByid(sid);
    }

    /**
     * 删除土壤信息
     * @param sid
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteSoilByid(String sid) {
        return soilMapper.deleteSoilByid(sid);
    }

    /**
     * 保存用户修改
     * @param soil
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateSoil(Soil soil) {
        return soilMapper.updateSoil(soil);
    }
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Soil> selectSoilListByids(List<String> sfids){
        return soilMapper.selectSoilListByids(sfids);
    }
}
