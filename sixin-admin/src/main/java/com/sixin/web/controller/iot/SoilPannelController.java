package com.sixin.web.controller.iot;

import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.core.controller.BaseController;
import com.sixin.iot.domain.MetCount;
import com.sixin.iot.domain.SoilDevice;
import com.sixin.iot.domain.Soilusetype;
import com.sixin.iot.service.ISoiluseTypeService;
import com.sixin.iot.service.impl.SoilDeviceServiceImpl;
import com.sixin.iot.service.impl.SoiluseServiceImpI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
@Controller
@RequestMapping("/iot/soilpannel")
public class SoilPannelController extends BaseController {
    @Autowired
    private SoiluseServiceImpI soiluseServiceImpI;
    @Autowired
    private SoilDeviceServiceImpl soilDeviceServiceImpl;
    private String prefix = "iot/soilpannel";

//主页
    @GetMapping()
    public String metpannel(){
        return prefix + "/Soil";
    }
//    分页查询页面
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List <Soilusetype> list= soiluseServiceImpI.select();
        return getDataTable(list);
    }
//    添加页面
    @GetMapping("/add")
    public String add()
    {
        return  prefix+"/AddDevice";
    }

    //ID查询页面
    @GetMapping("/selectbyid")
    public String selectbyid(Model model, @RequestParam("did") String did) {
//        判断是否为空
        int res=0;
        if (StringUtils.isEmpty(did)) {
            return "error/null";
        }
        model.addAttribute("device", soilDeviceServiceImpl.selectbyid(did));
//        if(res==0)
//            return "iot/Sure";
        return  prefix+"/SoilDeviceManage";
    }

    //     地域查询页面
    @GetMapping("/selectbyname")

    public String selectbyname(Model model, @RequestParam("dname") String dname)
    //        判断是否为空
    {
        if (StringUtils.isEmpty(dname)) {
            return "error/null";
        }
        model.addAttribute("device", soilDeviceServiceImpl.selectbyname(dname));
        return prefix+ "/SoilDeviceManage";
    }
    @PostMapping("/listdevice")
    @ResponseBody
    public TableDataInfo listdevice()
    {
        startPage();
        List <SoilDevice> list= soilDeviceServiceImpl.selectall();
        return getDataTable(list);
    }

}
