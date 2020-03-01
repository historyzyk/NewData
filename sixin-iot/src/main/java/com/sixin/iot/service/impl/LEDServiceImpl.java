package com.sixin.iot.service.impl;

import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.LED;
import com.sixin.iot.mapper.LEDMapper;
import com.sixin.iot.service.ILEDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LEDServiceImpl implements ILEDService {
    @Autowired
    private LEDMapper LEDMapper;
    /**
     * 查询终端运转列表
     *
     * @param led 终端运转信息
     * @return 终端运转集合
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<LED> selectLedList(LED led)
    {
        return LEDMapper.selectLedList(led);
    }

    /**
     * 查询终端运转信息
     *
     * @param led_id 终端运转ID
     * @return 终端运转信息
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public LED selectLedById(String led_id)
    {
        return LEDMapper.selectLedById(led_id);
    }

   /*@Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<LED> selectLedAll()
    {
        return LEDMapper.selectLedAll();
    }*/



    /**
     * 新增终端运转
     *
     * @param led 终端运转信息
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertLed(LED led)
    {
        return LEDMapper.insertLed(led);
    }

    /**
     * 修改终端运转
     *
     * @param led 终端运转信息
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateLed(LED led)
    {
        return LEDMapper.updateLed(led);
    }

    /**
     * 删除终端运转对象
     *
     * @param led_ids 需要删除的数据ID
     * @return 结果

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteLedByIds(String led_ids)
    {
        String[] Led_ids = Convert.toLongArray(led_ids);
         /*for (Long Led_id : Led_ids)
        {
            LED Led = selectLedById(Led_id);
           if (countUserPostById(postId) > 0)
            {
                throw new BusinessException(String.format("%1$s已分配,不能删除", post.getPostName()));
            }
        }
        return LEDMapper.deleteLedByIds(Led_ids);
    }
    /*public int deleteLedById(String led_id)
    {
        return LEDMapper.deleteLedById(led_id);
    }*/

    /**
     * 删除终端运转对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
   @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteLedByIds(String ids)
    {
        //return LEDMapper.deleteLedByIds(led_ids);
        return LEDMapper.deleteLedByIds(Convert.toStrArray(ids));
    }
    /**
     * 统计物联网数据条目
     *
     * @param led_id 终端运转ID
     * @return 终端运转信息

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int countall(){
        return LEDMapper.countall();
    }

    /**
     * 统计物联网设备数量
     *
     * @param led_id 终端运转ID
     * @return 终端运转信息

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int devicecount(){
        return LEDMapper.devicecount();
    }*/


}