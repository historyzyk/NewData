package com.sixin.iot.service;


import com.sixin.iot.domain.Broad;

import java.util.List;

/**
 * @program: BroadSys
 * @description: 广播系统
 * @author: 饶泽敏
 * @create: 2019-12-24 15:40
 **/


public interface BroadService {
    /**
     * 查询广播记录列表
     *
     * @return
     */
    public List<Broad> selectBroadList(Broad broad);

    /**
     * 根据broad_id选择数据
     * @param broad_id
     * @return
     */
    public Broad selectBroadByid(String broad_id);

    /**
     * 添加广播信息
     * @param  broad
     * @return
     */
    public int insertBroad(Broad broad);

    /**
     * 保存用户修改
     * @param Broad
     * @return
     */
    public int updateBroad(Broad Broad);

    /**
     * 删除广播信息
     * @param broad_id
     * @return

    public int deleteBroadByid(String broad_id);*/

    /**
     * 根据broad_id批量删除数据
     * @param broad_ids
     */
    public int deleteBroadByids(String ids);




}
