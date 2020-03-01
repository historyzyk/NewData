package com.sixin.web.controller.iot;

//import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.iot.domain.Torrent;
import com.sixin.iot.domain.Waterpannel;
import com.sixin.iot.service.IWaterpannelService;
import com.sixin.iot.service.impl.WaterpannelServiceImpl;
import com.sixin.rivervis.domain.EnvData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/iot/waterpannel")
public class WaterPannelController extends BaseController {
    private String prefix = "iot/waterpannel";

    @Autowired
    private WaterpannelServiceImpl waterpannelService;
    //private WaterpannelServiceImpl waterpannelServiceImpl;

    @GetMapping()
    public   String water() {
        return prefix + "/waterpannel";
    }

    /**
     * 导出水质监测列表
     */

    @PostMapping ("/view")
    @ResponseBody
    public TableDataInfo List() {
        startPage();
        List<Waterpannel> list =waterpannelService.selectWaterpannelList();
        return getDataTable(list);
    }

    @PostMapping ("/list")
    public String selectListById(Model model,@RequestParam("id") Integer id){
        model.addAttribute("data",waterpannelService.selectListById(id));
        return "iot/waterpannel/wselect";
    }



    @PostMapping ("/delete")
    public String deleteListById(Model model,@RequestParam("id") Integer id){
        model.addAttribute("dedata",waterpannelService.deleteListById(id));
        return "iot/waterpannel/wdelete";
    }




//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    @RequiresPermissions("iot:waterpannel:add")
//    @Log(title = "水质监测", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(Waterpannel waterpannel)
//    {
//
//        return toAjax(waterpannelService.insertWaterpannel(waterpannel));
//    }

    /**
     * 修改水质监测
     */
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
//    {
//        Waterpannel waterpannel = waterpannelService.selectWaterpannelById(id);
//        mmap.put("waterpannel", waterpannel);
//        return prefix + "/edit";
//    }

//    /**
//     * 修改保存水质监测
//     */
//    @RequiresPermissions("iot:waterpannel:edit")
//    @Log(title = "水质监测", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(Waterpannel waterpannel)
//    {
//        return toAjax(waterpannelService.updateWaterpannel(waterpannel));
//    }



}

