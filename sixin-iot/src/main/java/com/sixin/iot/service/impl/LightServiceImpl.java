package com.sixin.iot.service.impl;
import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Light;
import com.sixin.iot.mapper.LightMapper;
import com.sixin.iot.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:  LightSys
 * @description: 路灯系统
 * @author: 饶泽敏
 * @create: 2019-12-25 14:40
 **/
@Service
public class LightServiceImpl implements LightService {
    @Autowired
    private LightMapper lightMapper;

    /**
     * 查询路灯记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Light> selectLightList(Light light) {
        return lightMapper.selectLightList(light);
    }

    /**
     * 根据id批量删除数据
     * @param id
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteLightByids(String nid) {
        return lightMapper.deleteLightByids(Convert.toStrArray(nid));
    }

    /**
     * 添加路灯公告数据
     * @param  Light
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertLight(Light light) {
        return lightMapper.insertLight(light);
    }

    /**
     * 根据nid选择数据
     * @param nid
     * @return
     */

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Light selectBynid(String nid) {
        return lightMapper.selectByid(nid);
    }


    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Light> selectLightListByids(List<String> sfids){
        return lightMapper.selectLightListByids(sfids);
    }

    /**
     * 删除路灯信息
     * @param Light
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteLightByid(String nid) {
        return lightMapper.deleteLightByid(nid);
    }

    /**
     * 保存用户修改
     * @param Light
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateLight(Light light) {
        return lightMapper.updateLight(light);
    }
}
