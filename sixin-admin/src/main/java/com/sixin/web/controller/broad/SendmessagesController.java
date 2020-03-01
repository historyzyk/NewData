package com.sixin.web.controller.broad;


import java.util.List;
import com.sixin.broad.domain.Sendmessages;
import com.sixin.broad.service.ISendmessagesService;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.utils.poi.ExcelUtil;
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
import com.sixin.common.core.page.TableDataInfo;

/**
 * 短信发送记录 信息操作处理
 * 
 * @author 张超
 * @date 2019-01-11
 */
@Controller
@RequestMapping("/broad/sendmessages")
public class SendmessagesController extends BaseController
{
    private String prefix = "broad/sendmessages";
	
	@Autowired
	private ISendmessagesService sendmessagesService;
	
	@RequiresPermissions("system:sendmessages:view")
	@GetMapping()
	public String sendmessages()
	{
	    return prefix + "/sendmessages";
	}
	
	/**
	 * 查询短信发送记录列表
	 */
	@RequiresPermissions("system:sendmessages:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Sendmessages sendmessages)
	{
		startPage();
        List<Sendmessages> list = sendmessagesService.selectSendmessagesList(sendmessages);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出短信发送记录列表
	 */
	@RequiresPermissions("system:sendmessages:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Sendmessages sendmessages)
    {
    	List<Sendmessages> list = sendmessagesService.selectSendmessagesList(sendmessages);
        ExcelUtil<Sendmessages> util = new ExcelUtil<Sendmessages>(Sendmessages.class);
        return util.exportExcel(list, "sendmessages");
    }
	
	/**
	 * 新增短信发送记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存短信发送记录
	 */
	@RequiresPermissions("system:sendmessages:add")
	@Log(title = "新增短信发送记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Sendmessages sendmessages)
	{		
		return toAjax(sendmessagesService.insertSendmessages(sendmessages));
	}

	/**
	 * 修改短信发送记录
	 */
	@GetMapping("/edit/{smid}")
	public String edit(@PathVariable("smid") Integer smid, ModelMap mmap)
	{
		Sendmessages sendmessages = sendmessagesService.selectSendmessagesById(smid);
		mmap.put("sendmessages", sendmessages);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存短信发送记录
	 */
	@RequiresPermissions("system:sendmessages:edit")
	@Log(title = "修改短信发送记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Sendmessages sendmessages)
	{		
		return toAjax(sendmessagesService.updateSendmessages(sendmessages));
	}
	
	/**
	 * 删除短信发送记录
	 */
	@RequiresPermissions("system:sendmessages:remove")
	@Log(title = "删除短信发送记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sendmessagesService.deleteSendmessagesByIds(ids));
	}
	
}
