package com.sixin.iot.service.impl;
import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Flood;
import com.sixin.iot.domain.Floodbytl;
import com.sixin.iot.mapper.FloodMapper;
import com.sixin.iot.service.FloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:  FloodSys
 * @description: 山洪系统
 * @author: 饶泽敏
 * @create: 2019-12-25 15:00
 **/
@Service
public class FloodServiceImpl implements FloodService {
    @Autowired
    private FloodMapper floodMapper;

    /**
     * 查询山洪记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodList(Flood flood) {
        return floodMapper.selectFloodList(flood);
    }

    /**
     * 根据id批量删除数据
     * @param id
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteFloodByids(String id) {
        return floodMapper.deleteFloodByids(Convert.toStrArray(id));
    }

    /**
     * 添加山洪公告数据
     * @param  Flood
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertFlood(Flood flood) {
        return floodMapper.insertFlood(flood);
    }

    /**
     * 根据id选择数据
     * @param id
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Flood selectByid(String id) {
        return floodMapper.selectByid(id);
    }

    /**
     * 删除山洪信息
     * @param Flood
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteFloodByid(String id) {
        return floodMapper.deleteFloodByid(id);
    }

    /**
     * 保存用户修改
     * @param Flood
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateFlood(Flood flood) {
        return floodMapper.updateFlood(flood);
    }

    /**
     * 查询山洪监测列表 前20条数据
     *
     * @param envData 山洪监测信息
     * @return 山洪监测集合
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodListLimit(String rid){
        return floodMapper.selectFloodListLimit(rid);
    }

    /**
     * 统计山洪数据总数
     * @author 饶泽敏 teavamc
     * @date 2019/12/30
     * @param []
     * @return int
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int countall(String rid){
        return floodMapper.countall(rid);
    }


    /**
     * 根据时间范围和查询条数统计山洪数据
     *
     * @param envData 山洪监测信息
     * @return 山洪监测集合
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodListbytl(Floodbytl floodbytl){
        Map<String,Object> map = new HashMap<>(16);
        map=getQueryHelper(floodbytl);
        List<Flood> list=floodMapper.selectFloodListbytl(map);
        return list;
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodList1(Flood flood) {
        return floodMapper.selectFloodList1(flood);
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodList2(Flood flood) {
        return floodMapper.selectFloodList1(flood);
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodList3(String rid){
        return floodMapper.selectFloodList3(rid);
    }


    private Map<String,Object> getQueryHelper(Floodbytl helper) {

        Map<String,Object> map = new HashMap<>(16);

        if(helper.getRid()!=null){
            map.put("rid", helper.getRid());
        }

        if(helper.getBegintime()!=null){
            map.put("begintime", helper.getBegintime());
        }

        if(helper.getEndtime()!=null){
            map.put("endtime", helper.getEndtime());
        }

        return map;
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Flood> selectFloodByids(List<String> sfids) {
        return floodMapper.selectFloodByids(sfids);
    }
}
