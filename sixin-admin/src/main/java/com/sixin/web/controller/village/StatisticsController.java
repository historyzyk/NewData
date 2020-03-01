package com.sixin.web.controller.village;

import com.sixin.common.annotation.Log;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.village.domain.Shishi;
import com.sixin.village.domain.Statistics;
import com.sixin.village.service.IStatisticsService;
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
@RequestMapping("/village/statistics")
public class StatisticsController extends BaseController {
    private String prefix= "village/statistics";

    @Autowired
    private IStatisticsService statisticsService;

    @RequiresPermissions("village:statistics:view")
    @GetMapping()
    public String statistics(){return prefix+"/statistics";}

    /**
     * 查询参数列表
     */
    @RequiresPermissions("village:statistics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Statistics statistics)
    {
        startPage();
        List<Statistics> list = statisticsService.selectStatisticsList(statistics);
        return getDataTable(list);
    }

    /**
     * 新增参数设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存参数设置
     */
    @RequiresPermissions("village:statistics:add")
    @Log(title = "参数设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Statistics statistics)
    {
        return toAjax(statisticsService.insertStatistics(statistics));
    }

    /**
     * 修改参数设置
     */
    @GetMapping("/edit/{valueid}")
    public String edit(@PathVariable("valueid") String valueid, ModelMap mmap)
    {
        Statistics statistics = statisticsService.selectStatisticsById(valueid);
        mmap.put("statistics", statistics);
        return prefix + "/edit";
    }

    /**
     * 修改保存参数设置
     */
    @RequiresPermissions("village:statistics:edit")
    @Log(title = "参数设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Statistics statistics)
    {
        return toAjax(statisticsService.updateStatistics(statistics));
    }

    /**
     * 删除参数设置
     */
    @RequiresPermissions("village:statistics:remove")
    @Log(title = "参数设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(statisticsService.deleteStatisticsByIds(ids));
    }

}
