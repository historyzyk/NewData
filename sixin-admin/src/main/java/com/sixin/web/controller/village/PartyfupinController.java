package com.sixin.web.controller.village;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sixin.common.annotation.Log;
import com.sixin.common.enums.BusinessType;
import com.sixin.village.domain.Partyfupin;
import com.sixin.village.service.IPartyfupinService;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.utils.poi.ExcelUtil;

/**
 * 扶贫工作 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-25
 */
@Controller
@RequestMapping("/village/partyfupin")
public class PartyfupinController extends BaseController
{
    private String prefix = "village/partyfupin";
	
	@Autowired
	private IPartyfupinService partyfupinService;
	
	@RequiresPermissions("village:partyfupin:view")
	@GetMapping()
	public String partyfupin()
	{
	    return prefix + "/partyfupin";
	}
	
	/**
	 * 查询扶贫工作列表
	 */
	@RequiresPermissions("village:partyfupin:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Partyfupin partyfupin)
	{
		startPage();
        List<Partyfupin> list = partyfupinService.selectPartyfupinList(partyfupin);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出扶贫工作列表
	 */
	@RequiresPermissions("village:partyfupin:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Partyfupin partyfupin)
    {
    	List<Partyfupin> list = partyfupinService.selectPartyfupinList(partyfupin);
        ExcelUtil<Partyfupin> util = new ExcelUtil<Partyfupin>(Partyfupin.class);
        return util.exportExcel(list, "partyfupin");
    }
	
	/**
	 * 新增扶贫工作
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存扶贫工作
	 */
	@RequiresPermissions("village:partyfupin:add")
	@Log(title = "扶贫工作", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Partyfupin partyfupin)
	{		
		return toAjax(partyfupinService.insertPartyfupin(partyfupin));
	}

	/**
	 * 修改扶贫工作
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") Integer mid, ModelMap mmap)
	{
		Partyfupin partyfupin = partyfupinService.selectPartyfupinById(mid);
		mmap.put("partyfupin", partyfupin);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存扶贫工作
	 */
	@RequiresPermissions("village:partyfupin:edit")
	@Log(title = "扶贫工作", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Partyfupin partyfupin)
	{		
		return toAjax(partyfupinService.updatePartyfupin(partyfupin));
	}
	
	/**
	 * 删除扶贫工作
	 */
	@RequiresPermissions("village:partyfupin:remove")
	@Log(title = "扶贫工作", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(partyfupinService.deletePartyfupinByIds(ids));
	}
	
}
