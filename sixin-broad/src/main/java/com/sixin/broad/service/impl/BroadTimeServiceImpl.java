package com.sixin.broad.service.impl;

import com.sixin.broad.domain.BroadTime;
import com.sixin.broad.mapper.BroadTimeMapper;
import com.sixin.broad.service.IBroadTimeService;
import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 根据时间和地区对广播数目的统计
 * @author 周博
 * @date 2019-01-15
 */
@Service
public class BroadTimeServiceImpl implements IBroadTimeService {
    @Autowired
    private BroadTimeMapper broadTimeMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<BroadTime> selectList() {
        return broadTimeMapper.selectList();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<BroadTime> selectListByDate() {
        return broadTimeMapper.selectListByDate();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public  List<BroadTime> selectListByScategory() {
        return broadTimeMapper.selectListByScategory();
    }

}
