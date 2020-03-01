package com.sixin.api.controller.iot;

import com.sixin.api.domain.RongApiRes;
import com.sixin.api.service.RongApiService;
import com.sixin.iot.domain.Tersga1;
import com.sixin.iot.service.impl.Soil3DServiceImpl;
import com.sixin.iot.service.impl.SoilDeviceServiceImpl;
import com.sixin.iot.service.impl.SoilWaterServiceImpl;
import com.sixin.iot.service.impl.TriggerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/iot")
@CrossOrigin
public class SoilApi {
 @Autowired
 private SoilWaterServiceImpl soilWaterService;
 @Autowired
 private SoilDeviceServiceImpl soilDeviceService;
 @Autowired
 private Soil3DServiceImpl soil3DService;
 @Autowired
 private TriggerServiceImpl triggerService;
    @CrossOrigin
    @GetMapping("/water")
    @ApiOperation(value = "根据时间统各阶段土壤含水量")
    public RongApiRes selectwaterList(){
        List pre = soilWaterService.select();
        RongApiRes test = RongApiService.get_list(pre);
        return test;    }
    @CrossOrigin
    @GetMapping("/note")
    @ApiOperation(value = "根据Note统计终端设备")
    public RongApiRes selectListBynote() {
        List pre = soilDeviceService.selectbynote();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }
    @GetMapping("/trigger")
    @ApiOperation(value = "触发器操作类型统计")
    public RongApiRes selectListByScategory() {
        List pre = triggerService.selectlist();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }
    @GetMapping(value = "/ds")
    @CrossOrigin
    @ApiOperation(value = "返回首页需要的统计数据")
    public RongApiRes bindex(){
        return RongApiService.get_bean(soilDeviceService.selectbyds());
    }
    @CrossOrigin
    @GetMapping("/sumterm")
    @ApiOperation(value = "按照终端地址进行运行状态的分组统计,包括分组地区、挂在数量、运行数量、停止数量、维修数量")
    public RongApiRes sumterm(){
        List pre = soil3DService.sumterm();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }



    @CrossOrigin
    @GetMapping("/sumtermSort")
    @ApiOperation(value = "(排序后）按照终端地址进行运行状态的分组统计,包括分组地区、挂在数量、运行数量、停止数量、维修数量")
    public RongApiRes sumtermSort(){
        List<Tersga1> pre = soil3DService.sumterm();
        sumtermQuickSort(pre,0,pre.size()-1);
        return RongApiService.get_list(pre);
    }
    public void sumtermQuickSort(List<Tersga1> list, int start, int end){
//        1、确定起始下标，默认Index=0处为基准值
//        2、若左右下标未相遇，右侧下标向左走，若遇到小于基准值的则停止；左侧下标向右走，若遇到大于基准值的则停止
//        3、交换左右下标的值，确保第一次左右下标相遇时，左侧值均小于等于基准值，右侧值均大于等于基准值
//        4、左右下标若相遇，交换基准值与其位置的值，完成第一次相遇，再使用分治递归处理左右两部分
        if (start < end){
            int left = start;
            int right = end;
            while (left != right){
                while (list.get(right).getSum() >= list.get(start).getSum() && right > left){
                    right--;
                }
                while (list.get(left).getSum() <= list.get(start).getSum() && right > left){
                    left++;
                }
                if (right > left){
                    Collections.swap(list,left,right);
                }
            }
            Collections.swap(list,left,start);
            sumtermQuickSort(list,start,left-1);
            sumtermQuickSort(list,right+1,end);
        }
    }


}
