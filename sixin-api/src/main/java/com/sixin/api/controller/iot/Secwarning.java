package com.sixin.api.controller.iot;/* *
 * @Description:
 * @param $params$
 * @Return: $returns$
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/12/27 16:03
 * @开发版本：综合练习V0.1
 */

import com.sixin.api.domain.RongApiRes;
import com.sixin.api.service.RongApiService;
import com.sixin.iot.service.ISecWarnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/security")
@CrossOrigin
@Api(value = "安防警报可视化")
public class Secwarning {

    @Autowired
    private ISecWarnService secWarnService;

    @CrossOrigin
    @GetMapping("/rain")
    @ApiOperation(value = "降雨量警报可视化")
    public RongApiRes selectRainList(){
        List pre = secWarnService.selectRainSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/pm")
    @ApiOperation(value = "空气质量警报可视化")

    public RongApiRes selectPmList(){
        List pre = secWarnService.selectPmSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/temp")
    @ApiOperation(value = "温度警报可视化")

    public RongApiRes selectTempList(){
        List pre = secWarnService.selectTempSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/wlevel")
    @ApiOperation(value = "水位警报可视化")

    public RongApiRes selectWlvlList(){
        List pre = secWarnService.selectWlvlSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/hum")
    @ApiOperation(value = "湿度警报可视化")

    public RongApiRes selectHumList(){
        List pre = secWarnService.selectHumSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/envsectype")
    @ApiOperation(value = "环境警报类型可视化")
    public RongApiRes selectEnvTypeList(){
        List pre = secWarnService.selectEnvTypeSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/watsectype")
    @ApiOperation(value = "水质警报类型可视化")
    public RongApiRes selectwatTypeList(){
        List pre = secWarnService.selectWatTypeSecList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/water")
    @ApiOperation(value = "水质警报3d可视化(毒理)")
    public RongApiRes water(){
        List pre = secWarnService.water();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/bac")
    @ApiOperation(value = "水质警报可视化(细菌数量)")
    public RongApiRes bacsec(){
        List pre = secWarnService.bacsec();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }
}
