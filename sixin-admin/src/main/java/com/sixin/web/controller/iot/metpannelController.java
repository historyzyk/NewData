package com.sixin.web.controller.iot;
/**
 * 周宇滔
 * 气象信息
 */

import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.MetCount;
import com.sixin.iot.service.IMetFindService;
import com.sixin.iot.service.IMetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/iot/metpannel")
public class metpannelController extends BaseController {
    private String prefix="iot/metpannel";


    @Autowired
    private IMetService metService;

    @Autowired
    private IMetFindService metfindService;

    @GetMapping()
    public String metpannel(){
        return prefix + "/metpannel";
    }



    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<MetCount> list = metService.selectMet();
        return getDataTable(list);
    }


    @PostMapping ("/find")
    public String selectListById(Model model, @RequestParam("id") String id){
        model.addAttribute("data",metfindService.selectfindMet(id));
        return "iot/metpannel/metfind";
    }

    @PostMapping ("/findname")
    public String selectListByarea(Model model, @RequestParam("rname") String rname){
        model.addAttribute("dataa",metfindService.selectfindnameMet(rname));
        return "iot/metpannel/metfindname";
    }

    @PostMapping ("/deleteid")
    public String deleteListById(Model model, @RequestParam("id") String id){
        model.addAttribute("deta",metfindService.deleteidMet(id));
        return "iot/metpannel/metdelete";
    }
}
