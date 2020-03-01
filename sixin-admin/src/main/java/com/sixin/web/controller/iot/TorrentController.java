package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.base.AjaxResult;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.page.TableDataInfo;
import com.sixin.common.utils.ExcelUtil;
import com.sixin.framework.web.base.BaseController;
import com.sixin.iot.domain.Torrent;
import com.sixin.iot.service.ITorrentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 终端运转 信息操作处理
 * 
 * @author 张超
 * @date 2019-03-03
 */
@Controller
@RequestMapping("/iot/torrent")
public class TorrentController extends BaseController
{
    private String prefix = "iot/torrent";
	
	@Autowired
	private ITorrentService torrentService;
	
	@RequiresPermissions("iot:torrent:view")
	@GetMapping()
	public String torrent()
	{
	    return prefix + "/torrent";
	}
	
	/**
	 * 查询终端运转列表
	 */
	@RequiresPermissions("iot:torrent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Torrent torrent)
	{
		startPage();
        List<Torrent> list = torrentService.selectTorrentList(torrent);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出终端运转列表
	 */
	@RequiresPermissions("iot:torrent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Torrent torrent)
    {
    	List<Torrent> list = torrentService.selectTorrentList(torrent);
        ExcelUtil<Torrent> util = new ExcelUtil<Torrent>(Torrent.class);
        return util.exportExcel(list, "torrent");
    }
	
	/**
	 * 新增终端运转
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存终端运转
	 */
	@RequiresPermissions("iot:torrent:add")
	@Log(title = "终端运转", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Torrent torrent)
	{		
		return toAjax(torrentService.insertTorrent(torrent));
	}

	/**
	 * 修改终端运转
	 */
	@GetMapping("/edit/{dataid}")
	public String edit(@PathVariable("dataid") Integer dataid, ModelMap mmap)
	{
		Torrent torrent = torrentService.selectTorrentById(dataid);
		mmap.put("torrent", torrent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存终端运转
	 */
	@RequiresPermissions("iot:torrent:edit")
	@Log(title = "终端运转", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Torrent torrent)
	{		
		return toAjax(torrentService.updateTorrent(torrent));
	}
	
	/**
	 * 删除终端运转
	 */
	@RequiresPermissions("iot:torrent:remove")
	@Log(title = "终端运转", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(torrentService.deleteTorrentByIds(ids));
	}
	
}
