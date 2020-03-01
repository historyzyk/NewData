package com.sixin.web.controller.system;

import com.sixin.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/system/media")
@Controller
public class SysMediaController extends BaseController {
    private String prefix = "system/media";
//system/media

    @RequiresPermissions("system:media:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/media";
    }
}
