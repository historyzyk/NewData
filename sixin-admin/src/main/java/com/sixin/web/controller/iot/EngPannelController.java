package com.sixin.web.controller.iot;

import com.sixin.common.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Controller
@RequestMapping("/iot/engpannel")
public class EngPannelController extends BaseController {
    private String prefix = "iot/engpannel";


    @GetMapping()
    public String metpannel(){
        return prefix + "/engpannel";
    }
}
