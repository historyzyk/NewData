package com.sixin.web.controller.village;

import com.sixin.common.annotation.Log;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.enums.BusinessType;
import com.sixin.village.domain.Warnset;
import com.sixin.village.service.IWarnsetService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Controller
@RequestMapping("/village/message")
public class MessagePannelController extends BaseController {
    private String prefix ="village/message";

    @Autowired
    private IWarnsetService warnsetService;

    @RequiresPermissions("village:message:view")
    @GetMapping()
    public String message(){
        return prefix + "/message";
    }

    /**
     * 查询报警提示列表
     */
    @RequiresPermissions("village:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warnset warnset)
    {
        startPage();
        List<Warnset> list = warnsetService.selectWarnsetList(warnset);
        return getDataTable(list);
    }

    /**
     * 新增报警提示
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报警提示
     */
    @RequiresPermissions("village:message:add")
    @Log(title = "报警提示", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warnset warnset)
    {
        return toAjax(warnsetService.insertWarnset(warnset));
    }

    /**
     * 修改报警提示
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Warnset warnset = warnsetService.selectWarnsetById(id);
        mmap.put("warnset", warnset);
        return prefix + "/edit";
    }

    /**
     * 修改保存报警提示
     */
    @RequiresPermissions("village:message:edit")
    @Log(title = "报警提示", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warnset warnset)
    {
        return toAjax(warnsetService.updateWarnset(warnset));
    }

    /**
     * 删除报警提示
     */
    @RequiresPermissions("village:message:remove")
    @Log(title = "报警提示", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warnsetService.deleteWarnsetByIds(ids));
    }

}
