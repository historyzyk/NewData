package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.iot.domain.Energy;
import com.sixin.iot.service.EnergyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/energy")
public class EnergyController extends BaseController {

    private String prefix = "iot/energy";

    @Autowired
    private EnergyService EnergyService;

    @RequiresPermissions("iot:energyinfo:view")
    @GetMapping()
    public String Energy(){
        return prefix+"/energy";
    }

    /** @author qwerty
     * @description 导出√中的数据
     *
     * @param sfids
     * @return
     */
    @Log(title = "终端导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:energyinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportEnergyByIds(@RequestParam("sjids") List<String> sfids) {
        List<Energy> list = EnergyService.selectEnergyListByids(sfids);
        ExcelUtil<Energy> util = new ExcelUtil<Energy>(Energy.class);
        return util.exportExcel(list, "Energy");
    }

    /**
     * Energy列表
     * @param energy
     * @return
     */
    //@RequiresPermissions("iot:energyinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Energy energy){
        startPage();
        List<Energy> list = EnergyService.selectEnergyList(energy);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Energy信息
     */
    @RequiresPermissions("iot:energyinfo:add")
    @Log(title = "Energy信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Energy energy)
    {
        return toAjax(EnergyService.insertEnergy(energy));
    }
    /**
     * 修改Energy信息
     */
    @GetMapping("/edit/{eid}")
    public String edit(@PathVariable("eid") String eid, ModelMap mmap)
    {
        Energy energy = EnergyService.selectByeid(eid);
        mmap.put("energy", energy);
        return prefix + "/edit";
    }
    /**
     * 修改保存Energy信息
     */
    @RequiresPermissions("iot:energyinfo:edit")
    @Log(title = "Energy信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Energy energy)
    {
        return toAjax(EnergyService.updateEnergy(energy));
    }
    /**
     * 删除Energy信息
     */
    @RequiresPermissions("iot:energyinfo:remove")
    @Log(title = "删除Energy信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //System.out.println("*******"+ids);
        return toAjax(EnergyService.deleteEnergyByids(ids));
    }
}