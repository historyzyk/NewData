package com.sixin.api.controller.iot;

import com.sixin.api.domain.RongApiRes;
import com.sixin.api.service.RongApiService;
import com.sixin.iot.service.IMilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@RestController
@RequestMapping("/iot/milpannel")
@CrossOrigin
@Api(value = "环境数据 - 统计计数类接口")
public class MilCount {
    @Autowired
    private IMilService milService;

    @CrossOrigin
    @GetMapping("/pm")
    @ApiOperation(value = "按照时间顺序最新500条")
    public RongApiRes milCount(){
        return RongApiService.get_list(milService.selectMilList());
    }

    @CrossOrigin
    @GetMapping("/pmtips")
    @ApiOperation(value = "按照时间顺序最新500条PM2.5的平均值")
    public RongApiRes milpmtips(){
        return RongApiService.get_list(milService.selectMilPm());
    }
}
