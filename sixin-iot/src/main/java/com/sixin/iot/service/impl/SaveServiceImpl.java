package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Save;
import com.sixin.iot.mapper.SaveMapper;
import com.sixin.iot.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SaveSys
 * @description: 安防惯例
 * @author: 饶泽敏
 * @create: 2019-12-24 15:40
 **/
@Service
public class SaveServiceImpl implements SaveService {
    @Autowired
    private SaveMapper saveMapper;

    /**
     * 查询安防记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Save> selectSaveList(Save save) {
        return saveMapper.selectSaveList(save);
    }

    /**
     * 根据info_id选择数据
     * @param info_id
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Save selectSaveByid(String info_id) {
        return saveMapper.selectSaveByid(info_id);
    }

    /**
     * 添加安防公告数据
     * @param  save
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertSave(Save save) {
        return saveMapper.insertSave(save);
    }


    /**
     * 根据id批量删除数据
     * @param info_id

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteSaveByid(String info_id) {
        return saveMapper.deleteSaveByids(Convert.toStrArray(info_id));
    }*/


    /**
     * 根据id删除安防信息
     * @param info_ids
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteSaveByids(String ids) {
        return saveMapper.deleteSaveByids(Convert.toStrArray(ids));
    }

    /**
     * 保存用户修改
     * @param save
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateSave(Save save) {
        return saveMapper.updateSave(save);
    }

}
