package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Flood;
import com.sixin.iot.domain.Floodbytl;
import com.sixin.iot.service.FloodService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/iot/flood")
public class FloodController extends BaseController {

    private String prefix = "/iot/flood";

    @Autowired
    private FloodService FloodService;

    @RequiresPermissions("iot:floodinfo:view")
    @GetMapping()
    public String Flood(){
        return prefix+"/flood";
    }

    /**
     * Flood列表
     * @param flood
     * @return
     */
    @RequiresPermissions("iot:floodinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Flood flood){
        startPage();
        List<Flood> list = FloodService.selectFloodList(flood);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(ModelMap mmap,Flood flood){
        mmap.put("flood", FloodService.selectFloodList2(flood));
        return prefix+"/add";
    }

    /**
     * 新增Flood信息
     */
    @RequiresPermissions("iot:floodinfo:add")
    @Log(title = "Flood信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Flood flood)
    {
        return toAjax(FloodService.insertFlood(flood));
    }


    /**
     *
     * 图形统计
     */
    @GetMapping("/analysis")
    public String analysis(Flood flood, Map<String, Object> map,Floodbytl floodbytl){
        map.put("flood", FloodService.selectFloodList1(flood));
        map.put("floodbytl",floodbytl);
        return prefix+"/analysis";
    }



    /**
     * 修改Flood信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap,Flood flood)
    {
        //Flood flood = FloodService.selectByid(id);
        mmap.put("flood",  FloodService.selectByid(id));
        mmap.put("flood1", FloodService.selectFloodList2(flood));
        return prefix + "/edit";
    }
    /**
     * 修改保存Flood信息
     */
    @RequiresPermissions("iot:floodinfo:edit")
    @Log(title = "Flood信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Flood flood)
    {
        return toAjax(FloodService.updateFlood(flood));
    }
    /**
     * 删除Flood信息
     */
    @RequiresPermissions("iot:floodinfo:remove")
    @Log(title = "删除Flood信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //System.out.println("*******"+id);
        return toAjax(FloodService.deleteFloodByids(ids));
    }



    /**
     * 导出终端运转列表
     */



    @Log(title = "Flood", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:floodinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportFloodByIds(@RequestParam("sjids") List<String> sfids)
    {
        List<Flood> list = FloodService.selectFloodByids(sfids);
        ExcelUtil<Flood> util = new ExcelUtil<Flood>(Flood.class);
        return util.exportExcel(list, "flood");
    }
}