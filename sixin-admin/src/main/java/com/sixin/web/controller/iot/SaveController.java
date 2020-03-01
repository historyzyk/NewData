package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Save;
import com.sixin.iot.service.SaveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/save")
public class SaveController extends BaseController {

    private String prefix = "iot/save";

    @Autowired
    private SaveService saveService;

    @RequiresPermissions("iot:saveinfo:view")
    @GetMapping()
    public String Save(){
        return prefix+"/save";
    }

    /**
     * Save列表
     * @param save
     * @return
     */
    @RequiresPermissions("iot:saveinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Save save){
        startPage();
        List<Save> list = saveService.selectSaveList(save);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Save信息
     */
    @RequiresPermissions("iot:saveinfo:add")
    @Log(title = "Save信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Save Save)
    {
        return toAjax(saveService.insertSave(Save));
    }

    /**
     * 导出终端运转列表
     */
    @Log(title = "Save", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:saveinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Save save)
    {
        List<Save> list = saveService.selectSaveList(save);
        ExcelUtil<Save> util = new ExcelUtil<Save>(Save.class);
        return util.exportExcel(list, "save");
    }
    /**
     * 修改Save信息
     */
    @GetMapping("/edit/{info_id}")
    public String edit(@PathVariable("info_id") String info_id, ModelMap mmap)
    {
        Save save = saveService.selectSaveByid(info_id);
        mmap.put("save", save);
        return prefix + "/edit";
    }
    /**
     * 修改保存Save信息
     */
    @RequiresPermissions("iot:saveinfo:edit")
    @Log(title = "Save信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Save save)
    {
        return toAjax(saveService.updateSave(save));
    }
    /**
     * 删除Save信息
     */
    @RequiresPermissions("iot:saveinfo:remove")
    @Log(title = "删除Save信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove/{info_id}")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(saveService.deleteSaveByids(ids));
    }

}