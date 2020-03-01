package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.iot.domain.Broad;
import com.sixin.iot.service.BroadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/broad")
public class BroadController extends BaseController {

    private String prefix = "iot/broad";

    @Autowired
    private BroadService BroadService;

    @RequiresPermissions("iot:broadinfo:view")
    @GetMapping()
    public String Broad(){
        return prefix+"/broad";
    }

    /**
     * Broad列表
     * @param broad
     * @return
     */
    @RequiresPermissions("iot:broadinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Broad broad){
        startPage();
        List<Broad> list = BroadService.selectBroadList(broad);
        return getDataTable(list);
    }
    /**
     * 导出终端运转列表
     */
    @Log(title = "Broad", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:broadinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Broad broad)
    {
        List<Broad> list = BroadService.selectBroadList(broad);
        ExcelUtil<Broad> util = new ExcelUtil<Broad>(Broad.class);
        return util.exportExcel(list, "broad");
    }
    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Broad信息
     */
    @RequiresPermissions("iot:broadinfo:add")
    @Log(title = "Broad信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Broad broad)
    {
        return toAjax(BroadService.insertBroad(broad));
    }
    /**
     * 修改Broad信息
     */
    @GetMapping("/edit/{broad_id}")
    public String edit(@PathVariable("broad_id") String broad_id, ModelMap mmap)
    {
        Broad broad = BroadService.selectBroadByid(broad_id);
        mmap.put("broad", broad);
        return prefix + "/edit";
    }
    /**
     * 修改保存Broad信息
     */
    @RequiresPermissions("iot:broadinfo:edit")
    @Log(title = "Broad信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Broad broad)
    {
        return toAjax(BroadService.updateBroad(broad));
    }
    /**
     * 删除Broad信息
     */
    @PostMapping( "/remove")
    @Log(title = "删除Broad信息", businessType = BusinessType.DELETE)
    @RequiresPermissions("iot:broadinfo:remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(BroadService.deleteBroadByids(ids));
    }

}