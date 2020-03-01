package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.iot.domain.Water;
import com.sixin.iot.service.WaterService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/water")
public class WaterController extends BaseController {

    private String prefix = "iot/water";

    @Autowired
    private WaterService WaterService;

    @RequiresPermissions("iot:waterinfo:view")
    @GetMapping()
    public String Water(){
        return prefix+"/water";
    }

    /**
     * Water列表
     * @param water
     * @return
     */
    @RequiresPermissions("iot:waterinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Water water){
        startPage();
        List<Water> list = WaterService.selectWaterList(water);
        return getDataTable(list);
    }
    /**
     * 导出终端运转列表
     */
    @Log(title = "Water", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:waterinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Water water)
    {
        List<Water> list = WaterService.selectWaterList(water);
        ExcelUtil<Water> util = new ExcelUtil<Water>(Water.class);
        return util.exportExcel(list, "water");
    }
    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Water信息
     */
    @RequiresPermissions("iot:waterinfo:add")
    @Log(title = "Water信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Water water)
    {
        return toAjax(WaterService.insertWater(water));
    }
    /**
     * 修改Water信息
     */
    @GetMapping("/edit/{wid}")
    public String edit(@PathVariable("wid") String wid, ModelMap mmap)
    {
        Water water = WaterService.selectBywid(wid);
        mmap.put("water", water);
        return prefix + "/edit";
    }
    /**
     * 修改保存Water信息
     */
    @RequiresPermissions("iot:waterinfo:edit")
    @Log(title = "Water信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Water water)
    {
        return toAjax(WaterService.updateWater(water));
    }
    /**
     * 删除Water信息
     */
    @RequiresPermissions("iot:waterinfo:remove")
    @Log(title = "删除Water信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //System.out.println("*******"+wid);
        return toAjax(WaterService.deleteWaterByids(ids));
    }
    /** @author qwerty
     * @description 导出√中的数据
     *
     * @param sfids
     * @return
     */
    @Log(title = "终端导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:waterinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportFireByIds(@RequestParam("sjids") List<String> sfids) {
        List<Water> list = WaterService.selectWaterListByids(sfids);
        ExcelUtil<Water> util = new ExcelUtil<Water>(Water.class);
        return util.exportExcel(list, "Water");
    }

}