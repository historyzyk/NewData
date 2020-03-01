package com.sixin.iot.service;/* *
 * @Description:
 * @param $params$
 * @Return: $returns$
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/12/26 17:23
 * @开发版本：综合练习V0.1
 */

import com.sixin.iot.domain.Secenvwarn;
import com.sixin.iot.domain.Secwatwarn;

import java.util.List;

public interface ISecWarnService {

    /**
     * 查询降雨安防警报
     *
     * @param
     * @return 降雨安防警报
     */
    public List<Secenvwarn> selectRainSecList();

    /**
     * 查询空气质量安防警报
     *
     * @param
     * @return 空气质量安防警报
     */
    public List<Secenvwarn> selectPmSecList();

    /**
     * 查询温度安防警报
     *
     * @param
     * @return 温度安防警报
     */
    public List<Secenvwarn> selectTempSecList();
    /**
     * 查询水位安防警报
     *
     * @param
     * @return 水位安防警报
     */
    public List<Secenvwarn> selectWlvlSecList();

    /**
     * 查询湿度安防警报
     *
     * @param
     * @return 湿度安防警报
     */
    public List<Secenvwarn> selectHumSecList();

    /**
     * 查询环境安防警报类型触发信息
     *
     * @param
     * @return 环境警报类型触发信息
     */
    public List<Secenvwarn> selectEnvTypeSecList();

    /**
     * 查询水质警报警报触发信息
     *
     * @param
     * @return 水质警报类型触发信息
     */
    public List<Secenvwarn> selectWatTypeSecList();

    /**
     * 按照时间显示水质警报信息(毒理)
     * @author 余新伟 teavamc
     * @date 2019/12/30
     * @param
     * @return java.util.List<com.sixin.iot.domain.Secwatwarn>
     */
    public List<Secwatwarn> water();

    /**
     * 按照时间显示水质警报信息(细菌数量)
     * @author 余新伟 teavamc
     * @date 2019/12/30
     * @param
     * @return java.util.List<com.sixin.iot.domain.Secwatwarn>
     */
    public List<Secwatwarn> bacsec();
}
