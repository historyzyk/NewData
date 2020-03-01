package com.sixin.web.controller.iot;

import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.iot.domain.AreaIot;
import com.sixin.iot.service.IAreaIotService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Controller
@RequestMapping("/iot/area")
public class AreaIotController extends BaseController {
    private String prefix = "iot/area";

    @Autowired
    private IAreaIotService areaIotService;

//    @RequiresPermissions("iot:area:view")
    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    /**
     * 查询终端地域列表
     */
//    @RequiresPermissions("iot:area:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AreaIot areaIot)
    {
        startPage();
        List<AreaIot> list = areaIotService.selectAreaList(areaIot);
        return getDataTable(list);
    }
    /**
     * 选择部门树
     */
    @GetMapping("/selectAreaIotTree/{AreaId}")
    public String selectAreaIotTree(@PathVariable("AreaId") String AreaId, ModelMap mmap)
    {
        mmap.put("area", areaIotService.selectAreaIotById(AreaId));
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData()
    {
        List<Map<String, Object>> tree = areaIotService.selectAreaTree(new AreaIot());
        return tree;
    }
}
