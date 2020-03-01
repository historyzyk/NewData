package com.sixin.iot.service.impl;
import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Environl;
import com.sixin.iot.mapper.EnvironlMapper;
import com.sixin.iot.service.EnvironlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnvironlServiceImpl  implements EnvironlService {
    @Autowired
    private EnvironlMapper environlMapper;

    /**
     * 查询环境记录列表
     *
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Environl> selectEnvironlList(Environl environl) {
        return environlMapper.selectEnvironlList(environl);
    }
    /**
     * 根据id批量删除数据
     *
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteEnvironlByids(String ids) {
        return environlMapper.deleteEnvironlByids(Convert.toStrArray(ids));
    }

    /**
     * 添加环境公告数据
     *
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertEnvironl(Environl environl) {
        return environlMapper.insertEnvironl(environl);
    }

    /**
     * 根据hid选择数据
     *
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Environl selectByid(String hid) {
        return environlMapper.selectByid(hid);
    }

    /**
     * 删除环境信息
     *
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteEnvironlByid(String hid) {
        return environlMapper.deleteEnvironlByid(hid);
    }

    /**
     * 保存用户修改
     *
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateEnvironl(Environl environl) {
        return environlMapper.updateEnvironl(environl);
    }
}