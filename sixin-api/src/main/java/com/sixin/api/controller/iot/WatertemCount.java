package com.sixin.api.controller.iot;

import com.sixin.api.domain.RongApiRes;
import com.sixin.api.service.RongApiService;
import com.sixin.iot.service.IWatertemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/iot")
@CrossOrigin
@Api(value = "物联网模块 - 水质数据")
public class WatertemCount {
    @Autowired
    private IWatertemService watertemService;
    @CrossOrigin
    @GetMapping("/tem")
    @ApiOperation(value = "水温")
    public RongApiRes temview(){
        List pre = watertemService.selecttem();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }
}
