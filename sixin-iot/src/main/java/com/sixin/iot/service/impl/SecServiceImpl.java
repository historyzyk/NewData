package com.sixin.iot.service.impl;/* *
 * @Description:
 * @param $params$
 * @Return: $returns$
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/12/20 14:27
 * @开发版本：综合练习V0.1
 */
import java.util.List;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.iot.domain.Security;
import com.sixin.iot.mapper.SecMapper;
import com.sixin.iot.service.ISecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecServiceImpl implements ISecService {

    @Autowired
    private SecMapper secMapper;

    /**
     * 获取所有安防警报类型
     *
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Security> selectSecList(){
        return secMapper.selectSecList();
    };

}
