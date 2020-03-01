package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Meteor;
import com.sixin.iot.service.MeteorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/meteor")
public class MeteorController extends BaseController {

    private String prefix = "iot/meteor";

    @Autowired
    private MeteorService MeteorService;

    @RequiresPermissions("iot:meteorinfo:view")
    @GetMapping()
    public String Meteor(){
        return prefix+"/meteor";
    }

    /**
     * Meteor列表
     * @param meteor
     * @return
     */
    @RequiresPermissions("iot:meteorinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Meteor meteor){
        startPage();
        List<Meteor> list = MeteorService.selectMeteorList(meteor);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }
    /**
     * 导出Meteor列表
     */
    @Log(title = "Meteor", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:Meteorinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Meteor meteor)
    {
        List<Meteor> list = MeteorService.selectMeteorList(meteor);
        ExcelUtil<Meteor> util = new ExcelUtil<Meteor>(Meteor.class);
        return util.exportExcel(list, "Meteor");
    }
    /**
     * 新增Meteor信息
     */
    @RequiresPermissions("iot:meteorinfo:add")
    @Log(title = "Meteor信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Meteor meteor)
    {
        return toAjax(MeteorService.insertMeteor(meteor));
    }
    /**
     * 修改Meteor信息
     */
    @GetMapping("/edit/{weather_id}")
    public String edit(@PathVariable("weather_id") String weather_id, ModelMap mmap)
    {
        Meteor meteor = MeteorService.selectByweather_id(weather_id);
        mmap.put("meteor", meteor);
        return prefix + "/edit";
    }
    /**
     * 修改保存Meteor信息
     */
    @RequiresPermissions("iot:meteorinfo:edit")
    @Log(title = "Meteor信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Meteor meteor)
    {
        return toAjax(MeteorService.updateMeteor(meteor));
    }
    /**
     * 删除Meteor信息
     */
    @RequiresPermissions("iot:meteorinfo:remove")
    @Log(title = "删除Meteor信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(MeteorService.deleteMeteorByids(ids));
    }
}