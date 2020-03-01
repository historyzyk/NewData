package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Light;
import com.sixin.iot.service.LightService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/light")
public class LightController extends BaseController {

    private String prefix = "iot/light";

    @Autowired
    private LightService LightService;

    @RequiresPermissions("iot:lightinfo:view")
    @GetMapping()
    public String Light(){
        return prefix+"/light";
    }

    /** @author qwerty
     * @description 导出√中的数据
     *
     * @param sfids
     * @return
     */
    @Log(title = "终端导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:lightinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportLightByIds(@RequestParam("sjids") List<String> sfids) {
        List<Light> list = LightService.selectLightListByids(sfids);
        ExcelUtil<Light> util = new ExcelUtil<Light>(Light.class);
        return util.exportExcel(list, "Light");
    }

    /**
     * Light列表
     * @param light
     * @return
     */
    //@RequiresPermissions("iot:lightinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Light light){
        startPage();
        List<Light> list = LightService.selectLightList(light);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Light信息
     */
    @RequiresPermissions("iot:lightinfo:add")
    @Log(title = "Light信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Light light)
    {
        return toAjax(LightService.insertLight(light));
    }
    /**
     * 修改Light信息
     */
    @GetMapping("/edit/{nid}")
    public String edit(@PathVariable("nid") String nid, ModelMap mmap)
    {
        Light light = LightService.selectBynid(nid);
        mmap.put("light", light);
        return prefix + "/edit";
    }
    /**
     * 修改保存Light信息
     */
    @RequiresPermissions("iot:lightinfo:edit")
    @Log(title = "Light信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Light light)
    {
        return toAjax(LightService.updateLight(light));
    }
    /**
     * 删除Light信息
     */
    @RequiresPermissions("iot:lightinfo:remove")
    @Log(title = "删除Light信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        System.out.println("*******"+ids);
        return toAjax(LightService.deleteLightByids(ids));
    }
}