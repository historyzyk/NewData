package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.iot.domain.Sandbox;
import com.sixin.iot.service.SandboxService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iot/sandbox")
public class SandboxController extends BaseController {
    private String prefix = "iot/sandbox";
    @Autowired
    private SandboxService SandboxService;
    @RequiresPermissions("iot:sandinfo:view")
    @GetMapping()
    public String Sandbox(){
        return prefix+"/sandbox";
    }

    /**
     *  Sandbox列表
     * @param Sandbox
     * @return
     */
    @RequiresPermissions("iot:sandinfo:list")
    @PostMapping("/list")
    @ResponseBody
        public TableDataInfo list(Sandbox Sandbox){
            startPage();
            List<Sandbox> list = SandboxService.selectSandboxList(Sandbox);
            return getDataTable(list);
        }
        @GetMapping("/add")
        public String add(){
            return prefix+"/add";
        }

        /**
         * 新增 Sandbox信息
         */
        @RequiresPermissions("iot:sandinfo:add")
        @Log(title = " Sandbox信息", businessType = BusinessType.INSERT)
        @PostMapping("/add")
        @ResponseBody
        public AjaxResult addSave(Sandbox sandbox)
        {
            return toAjax(SandboxService.insertSandbox(sandbox));
        }
        /**
         * 修改 Sandbox信息
         */
        @GetMapping("/edit/{switch_id}")
        public String edit(@PathVariable("switch_id") String switch_id, ModelMap mmap)
        {
            Sandbox sandbox = SandboxService.selectByid(switch_id);
            mmap.put("sandbox", sandbox);
            return prefix + "/edit";
        }
        /**
         * 修改保存 Sandbox信息
         */
        @RequiresPermissions("iot:sandinfo:edit")

        @Log(title = " Sandbox信息", businessType = BusinessType.UPDATE)
        @PostMapping("/edit")
        @ResponseBody
        public AjaxResult editSave(Sandbox sandbox)
        {
            return toAjax(SandboxService.updateSandbox(sandbox));
        }
        /**
         * 删除 Sandbox信息
         */
        @RequiresPermissions("iot:sandinfo:remove")
        @Log(title = "删除 Sandbox信息", businessType = BusinessType.DELETE)

        @PostMapping( "/remove")
        @ResponseBody
        public AjaxResult remove(String ids)
        {
          //  System.out.println("*******"+switch_id);
            return toAjax(SandboxService.deleteSandboxByids(ids));
        }


    /**
     * 导出终端运转列表
     */
    @Log(title = "Sandbox", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:sandboxinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Sandbox sandbox)
    {
        List<Sandbox> list = SandboxService.selectSandboxList(sandbox);
        ExcelUtil<Sandbox> util = new ExcelUtil<Sandbox>(Sandbox.class);
        return util.exportExcel(list, "sandbox");
    }
    }