package com.sixin.iot.mapper;

import com.sixin.iot.domain.Save;

import java.util.List;

public interface SaveMapper {
    /**
     * 安防记录列表
     *
     * @return
     */
    List<Save> selectSaveList(Save save);

    /**
     * 根据info_id选择数据
     * @param info_id
     * @return
     */
    Save selectSaveByid(String info_id);

    /**
     * 添加安防信息
     * @param save
     * @return
     */
    int insertSave(Save save);

    /* 根据info_id删除数据
     * 根据info_id批量删除数据
     * @param info_id
     */
    int deleteSaveByids(String[] info_ids);

    /**
     * 保存用户修改
     * @param save
     * @return
     */
    int updateSave(Save save);
    /**
     * 删除安防信息
     * @param info_id
     * @return

    int deleteSaveByid(String info_id);*/
}