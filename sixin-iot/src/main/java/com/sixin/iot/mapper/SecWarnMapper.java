package com.sixin.iot.mapper;/* *
 * @Description:
 * @param $params$
 * @Return: $returns$
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/12/26 17:24
 * @开发版本：综合练习V0.1
 */

import com.sixin.iot.domain.Secenvwarn;
import com.sixin.iot.domain.Secwatwarn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecWarnMapper {

    /**
     * 获取所有降雨安防警报信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectRainSecList();

    /**
     * 获取所有空气质量安防警报信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectPmSecList();

    /**
     * 获取所有温度安防警报信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectTempSecList();

    /**
     * 获取所有水位安防警报信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectWlvlSecList();

    /**
     * 获取所有湿度安防警报信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectHumSecList();
    /**
     * 获取环境警报类型触发信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectEnvTypeSecList();

    /**
     * 获取水质警报类型触发信息
     *
     * @return 结果
     */
    public List<Secenvwarn> selectWatTypeSecList();
    /**
     * 获取水质警报（毒理）触发信息
     *
     * @return 结果
     */
    public List<Secwatwarn> water();
    /**
     * 获取水质警报（细菌数量）触发信息
     *
     * @return 结果
     */
    public List<Secwatwarn> bacsec();
}
