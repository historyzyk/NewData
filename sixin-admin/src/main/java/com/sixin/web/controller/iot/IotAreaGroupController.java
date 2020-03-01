package com.sixin.web.controller.iot;

import com.sixin.broad.domain.BroadMessage;
import com.sixin.common.annotation.Log;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.framework.util.ShiroUtils;
import com.sixin.common.core.controller.BaseController;
import com.sixin.iot.domain.AreaIotGroup;
import com.sixin.iot.domain.IotMessage;
import com.sixin.iot.service.IIotAreaGroupService;
import com.sixin.iot.service.IIotMessageService;
import com.sixin.system.domain.SysUser;
import com.sixin.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Controller
@RequestMapping("/iot/iotareaGroup")
public class IotAreaGroupController extends BaseController {
    private String prefix = "iot/iotareaGroup";

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private IIotAreaGroupService iIotAreaGroupService;
    @Autowired
    private IIotMessageService iIotMessageService;
//    @RequiresPermissions("broad:areaGrouping:view")
    @GetMapping()
    public String areaGrouping()
    {
        return prefix + "/iotareaGroup";
    }

    @PostMapping("/list")
    @Log(title = "分组管理列表")
//    @RequiresPermissions("broad:areaGrouping:list")
    @ResponseBody
    public TableDataInfo list(AreaIotGroup areaIotGroup)
    {
        SysUser currentUser = ShiroUtils.getSysUser();  //从session中获取当前登陆用户的userid
        Long userid = currentUser.getUserId();
        //int returnid = new Long(userid).intValue();
        int roleid = iSysUserService.selectRoleid(userid); //通过所获取的userid去广播用户表中查询用户所属区域的Roleid
        if(roleid == 1)
        {
            startPage();
            List<AreaIotGroup> list = iIotAreaGroupService.listAreaIotGroup(areaIotGroup);
            return getDataTable(list);
        }else {
            startPage();
            areaIotGroup.setUid(userid);
            List<AreaIotGroup> list = iIotAreaGroupService.listAreaIotGroup(areaIotGroup);
            return getDataTable(list);
        }
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData() {
        List<Map<String, Object>> tree = iIotMessageService.selectiotMessageList((new IotMessage()));
        return tree;
    }
}
