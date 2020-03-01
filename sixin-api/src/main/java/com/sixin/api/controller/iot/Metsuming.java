package com.sixin.api.controller.iot;

import com.sixin.api.domain.RongApiRes;
import com.sixin.api.service.RongApiService;
import com.sixin.iot.service.IMetSumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
@RestController
@RequestMapping("/api/met")
@CrossOrigin
@Api(value = "气象数据")
public class Metsuming {

    @Autowired
    private IMetSumService metsumservice;

    @CrossOrigin
    @GetMapping("/rain")
    @ApiOperation(value = "降雨量")
    public RongApiRes selectRainList(){
        List pre = metsumservice.selectRainMet();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }


    @GetMapping("/hum")
    @ApiOperation(value = "湿度")

    public RongApiRes selectHumList(){
        List pre = metsumservice.selectHumMet();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }


    @GetMapping("/see")
    @ApiOperation(value = "可见度")

    public RongApiRes selectSeeList(){
        List pre = metsumservice.selectSeeMet();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/river")
    @ApiOperation(value = "水位")

    public RongApiRes selectRiverList(){
        List pre = metsumservice.selectRiverMet();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }
}
