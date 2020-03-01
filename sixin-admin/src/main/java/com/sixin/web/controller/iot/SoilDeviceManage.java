package com.sixin.web.controller.iot;

import com.sixin.iot.service.impl.SoilDeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/iot/device")
public class SoilDeviceManage {
    @Autowired
    private SoilDeviceServiceImpl soilDeviceService;

//        查询所有
    @GetMapping("/selectall")
    public String showall(Model model) {
        model.addAttribute("device", soilDeviceService.selectall());
        return "iot/soilpannel/SoilDeviceManage";
    }
    @GetMapping("devicemanage")
    public String show()
    {
        return "iot/soilpannel/DeviceManage";
    }


    @GetMapping("/adddevice")
    public String add(@RequestParam("did") String did, @RequestParam("dname") String dname,
                      @RequestParam("dstatus") int dstatus, @RequestParam("dv") int dv, @RequestParam("dctime1") String dctime1
            , @RequestParam("dftime1") String dftime1, @RequestParam("dcname") String dcname, @RequestParam("dfname") String dfname
            , @RequestParam("note") String note) {
        int res = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dctime = simpleDateFormat.parse(dctime1);
            Date dftime = simpleDateFormat.parse(dftime1);
            res = soilDeviceService.add(did, dname, dstatus, dv, dctime, dftime, dcname, dfname, note);
            if (res == 0) {
                return "error/Sure";
            } else {
                return "error/addsucess";
            }
        } catch (ParseException px) {
            px.printStackTrace();
            return "error/404";
        }
    }

    //    地域删除
    @GetMapping("deletebyname")
    public String deletebyname(Model model, @RequestParam("dname") String dname) {
        int res = 0;
        {
            if (StringUtils.isEmpty(dname)) {
                return "error/null";
            }
            res = soilDeviceService.deletebyname(dname);
            if (res == 0) {
                return "error/Sure";
            } else {
                return "error/delete";
            }
        }
    }
}


