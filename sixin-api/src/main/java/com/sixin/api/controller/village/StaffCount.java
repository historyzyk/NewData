package com.sixin.api.controller.village;

import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.village.domain.Staff;
import com.sixin.village.mapper.StaffMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sixin.api.domain.RongApiRes;
import com.sixin.api.service.RongApiService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sixin.village.service.IStaffService;
/**
 * 工作人员信息 控制层
 *
 * @author 薛莎莎
 * @date 2019-11-25
 */

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
@Api(value = "工作人员信息")
public class StaffCount extends BaseController{
    @Autowired
    private IStaffService staffService;
    @CrossOrigin
    @GetMapping("/list")
    @ApiOperation(value = "查询工作人员信息列表")
    public RongApiRes list(Staff staff){
        return RongApiService.get_list(staffService.selectStaffList(staff));
    }
}
