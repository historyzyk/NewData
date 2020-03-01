package com.sixin.iot.service;

import com.sixin.iot.domain.Save;

import java.util.List;

/**
 * @program: SaveSys
 * @description: 安防系统
 * @author: 饶泽敏
 * @create: 2019-12-24 15:40
 **/


public interface SaveService {
    /**
     * 查询安防记录列表
     *
     * @return
     */
    public List<Save> selectSaveList(Save save);

    /**
     * 根据infoid选择数据
     * @param info_id
     * @return
     */
    public Save selectSaveByid(String info_id);

    /**
     * 添加安防公告数据
     * @param  save
     * @return
     */
    public int insertSave(Save save);

    /**
     * 根据info_id批量删除数据
     * @param info_ids
     */
    public int deleteSaveByids(String info_ids);

    /**
     * 保存用户修改
     * @param save
     * @return
     */
    public int updateSave(Save save);
    /**
     * 删除安防信息
     * @param info_id
     * @return

    public int deleteSaveByid(String info_id);*/

}
