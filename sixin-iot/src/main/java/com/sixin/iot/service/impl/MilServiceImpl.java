package com.sixin.iot.service.impl;

import com.sixin.iot.domain.EnvirData;
import com.sixin.iot.domain.RiverData;
import com.sixin.iot.mapper.MilMapper;
import com.sixin.iot.mapper.RiverDataMapper;
import com.sixin.iot.service.IMilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;


/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */

@Service
public class MilServiceImpl implements IMilService {
    @Autowired
    private MilMapper milMapper;
    @Autowired
    private RiverDataMapper riverDataMapper;
    public List<EnvirData> selectMilList(){
        return milMapper.selectMilList();
    }

    public List<EnvirData> selectMilPm(){
        List<EnvirData> res=milMapper.selectMilPm();
        for(EnvirData envirData:res){
            Double pm= Double.parseDouble(envirData.getPm());
            if(pm>=0&&pm<=50)envirData.setTips("空气质量优，适合多外出运动、散步、去公园散步等");
            else if(pm>=51&&pm<=100)envirData.setTips("空气质量良好，适合外出运动、散步、去公园散步等");
            else if(pm>=101&&pm<=200)envirData.setTips("空气质量为轻度污染,敏感人群症状易加剧，应避免高强度户外锻炼，外出时做好防护措施");
            else if(pm>=201&&pm<=300)envirData.setTips("空气质量为中度污染,心脏病和肺病患者症状显著加剧，运动耐受力降低，健康人群中普遍出现症状,减少外出");
            else envirData.setTips("空气质量为重度污染。健康人运动耐受力降低，有明显症状并出现某些疾病,尽量不外出");
            DecimalFormat df = new DecimalFormat("0.00");
            String d= df.format(pm);envirData.setPm(d);
        }
        return res;
    }
//    public List<RiverData> selectData(String rname){
//        return riverDataMapper.selectData(rname);
//    }
}
