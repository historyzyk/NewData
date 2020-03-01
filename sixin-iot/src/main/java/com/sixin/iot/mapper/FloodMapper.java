package com.sixin.iot.mapper;
import com.sixin.iot.domain.Flood;

import java.util.List;
import java.util.Map;

public interface FloodMapper {
    /**
     * 山洪灾害记录列表
     *
     * @return
     */
    List<Flood> selectFloodList(Flood flood);

    /**
     * 根据id批量删除数据
     * @param id
     */
    int deleteFloodByids(String[] id);
    /**
     * 添加山洪灾害信息
     * @param flood
     * @return
     */
    int insertFlood(Flood flood);
    /**
     * 根据id选择数据
     * @param id
     * @return
     */
    Flood selectByid(String id);

    /**
     * 保存用户修改
     * @param flood
     * @return
     */
    int updateFlood(Flood flood);
    /**
     * 删除山洪灾害信息
     * @param id
     * @return
     */
    int deleteFloodByid(String id);

    /**
     * 查询山洪监测列表 前20条数据
     *
     * @param flood 环境监测信息
     * @return 环境监测集合
     */
    public List<Flood> selectFloodListLimit(String rid);

    /**
     * 统计山洪数据总数
     * @author 饶泽敏 teavamc
     * @date 2019/12/30
     * @param []
     * @return int
     */
    public int countall(String rid);

    public List<Flood> selectFloodListbytl(Map map);

    List<Flood> selectFloodList1(Flood flood);

    List<Flood> selectFloodList2(Flood flood);

    public List<Flood> selectFloodList3(String rid);

    public List<Flood> selectFloodByids(List<String> sfids);
}