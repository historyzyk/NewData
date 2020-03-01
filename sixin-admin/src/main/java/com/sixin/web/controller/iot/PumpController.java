package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Pump;
import com.sixin.iot.service.PumpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/pump")
public class PumpController extends BaseController {

    private String prefix = "iot/pump";

    @Autowired
    private PumpService PumpService;

    @RequiresPermissions("iot:pumpinfo:view")
    @GetMapping()
    public String Pump(){
        return prefix+"/pump";
    }

    /**
     * Pump列表
     * @param pump
     * @return
     */
    //@RequiresPermissions("iot:pumpinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pump pump){
        startPage();
        List<Pump> list = PumpService.selectPumpList(pump);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Pump信息
     */
    @RequiresPermissions("iot:pumpinfo:add")
    @Log(title = "Pump信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Pump pump)
    {
        return toAjax(PumpService.insertPump(pump));
    }
    /**
     * 修改Pump信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Pump pump = PumpService.selectByid(id);
        mmap.put("pump", pump);
        return prefix + "/edit";
    }

    /** @author qwerty
     * @description 导出√中的数据
     *
     * @param sfids
     * @return
     */
    @Log(title = "终端导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:pumpinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportPumpByIds(@RequestParam("sjids") List<String> sfids) {
        List<Pump> list = PumpService.selectPumpListByids(sfids);
        ExcelUtil<Pump> util = new ExcelUtil<Pump>(Pump.class);
        return util.exportExcel(list, "Pump");
    }
    /**
     * 修改保存Pump信息
     */
    @RequiresPermissions("iot:pumpinfo:edit")
    @Log(title = "Pump信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Pump pump)
    {
        return toAjax(PumpService.updatePump(pump));
    }
    /**
     * 删除Pump信息
     */
    @RequiresPermissions("iot:pumpinfo:remove")
    @Log(title = "删除Pump信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        System.out.println("*******"+ids);
        return toAjax(PumpService.deletePumpByids(ids));
    }
}