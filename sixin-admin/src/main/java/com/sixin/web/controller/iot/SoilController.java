package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Soil;
import com.sixin.iot.service.SoilService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/soil")
public class SoilController extends BaseController {

    private String prefix = "iot/soil";

    @Autowired
    private SoilService SoilService;

    @RequiresPermissions("iot:soilinfo:view")
    @GetMapping()
    public String Soil(){
        return prefix+"/soil";
    }

    /**
     * Soil列表
     * @param soil
     * @return
     */
    @RequiresPermissions("iot:soilinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Soil soil){
        startPage();
        List<Soil> list = SoilService.selectSoilList(soil);
        return getDataTable(list);
    }
    /**
     * 导出终端运转列表
     */
    @Log(title = "Soil", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:soilinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Soil soil)
    {
        List<Soil> list = SoilService.selectSoilList(soil);
        ExcelUtil<Soil> util = new ExcelUtil<Soil>(Soil.class);
        return util.exportExcel(list, "soil");
    }
    /**
     * 新增
     */
    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增保存
     */
    @RequiresPermissions("iot:soilinfo:add")
    @Log(title = "Soil信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Soil soil)
    {
        return toAjax(SoilService.insertSoil(soil));
    }
    /**
     * 修改Soil信息
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        Soil soil = SoilService.selectBysid(sid);
        mmap.put("soil", soil);
        return prefix + "/edit";
    }
    /**
     * 修改保存Soil信息
     */
    @RequiresPermissions("iot:soilinfo:edit")
    @Log(title = "Soil信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Soil soil)
    {
        return toAjax(SoilService.updateSoil(soil));
    }
    /**
     * 删除Soil信息
     */
    @RequiresPermissions("iot:soilinfo:remove")
    @Log(title = "删除Soil信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //System.out.println("*******"+sid);
        return toAjax(SoilService.deleteSoilByids(ids));
    }
    /** @author qwerty
     * @description 导出√中的数据
     *
     * @param sfids
     * @return
     */
    @Log(title = "终端导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:soilinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportFireByIds(@RequestParam("sjids") List<String> sfids) {
        List<Soil> list = SoilService.selectSoilListByids(sfids);
        ExcelUtil<Soil> util = new ExcelUtil<Soil>(Soil.class);
        return util.exportExcel(list, "Soil");
    }
}