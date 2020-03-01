/*
package com.sixin.iot.domain;

public class LED {

    private String Led_id;

    private String led_Status;

    private String led_Bright;


    private String screen_wide;

    private String screen_high;


    private String screen_status;

    public String toString() {
        return "LED{" +
                "led_id='" + Led_id + '\'' +
                ", led_status='" + led_Status + '\'' +
                ", led_bright='" + led_Bright + '\'' +
                ", screen_wide='" + screen_wide + '\'' +
                ", screen_high='" + screen_high + '\'' +
                ", screen_status='" + screen_status + '\'' +
                '}';
    }



    public LED(String Led_id, String led_Status, String led_Bright, String screen_wide,String screen_high, String screen_status) {
        this.Led_id = Led_id;
        this.led_Status = led_Status;
        this.led_Bright = led_Bright;
        this.screen_wide = screen_wide;
        this.screen_high = screen_high;
        this.screen_status = screen_status;
    }

    public LED() {
        super();
    }

    public String Led_id() {
        return Led_id;
    }

    public void setLed_id(String led_id) {
        this.Led_id = led_id;
    }

    public String led_Status() {
        return led_Status;
    }

    public void setled_Status(String led_status) {
        this.led_Status = led_status;
    }

    public String getLed_bright() {
        return led_Bright;
    }

    public void setLed_bright(String led_bright) {
        this.led_Bright = led_bright;
    }

    public String getScreen_wide() {
        return screen_wide;
    }

    public void setScreen_wide(String screen_wide) {
        this.screen_wide = screen_wide;
    }

    public String getScreen_high() {
        return screen_high;
    }

    public void setScreen_high(String screen_high) {
        this.screen_high = screen_high;
    }

    public String getScreen_status() {
        return screen_status;
    }

    public void setScreen_status(String screen_status) {
        this.screen_status = screen_status;
}
}*/
package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class LED {
    @Excel(name = "LED显示编号")
    private String Led_id;
    @Excel(name = "用户编号")
    private String uid;
    @Excel(name = "终端号")
    private String tid;
    @Excel(name = "LED显示信息文字")
    private String content;
    @Excel(name = "开始显示时间")
    private String stardate;
    @Excel(name = "显示结束时间")
    private String enddate;
    @Excel(name = "创建时间")
    private String createtime;
    @Excel(name = "特效")
    private String effect;
    @Excel(name = "颜色")
    private String color;
    @Excel(name = "备注")
    private String demo;
    @Excel(name = "是否有效",readConverterExp = "N=否,Y=是")
    private String remark;
    private String deptId;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "LED{" +
                "led_id='" + Led_id + '\'' +
                ", uid='" + uid + '\'' +
                ", tid='" + tid + '\'' +
                ", content='" + content + '\'' +
                ", stardate='" + stardate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", createtime='" + createtime + '\'' +
                ", effect='" + effect + '\'' +
                ", color='" + color + '\'' +
                ", demo='" + demo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
    public LED(String Led_id, String uid, String tid, String content, String stardate,String enddate,String createtime,String effect,String color,String demo,String remark) {
        this.Led_id = Led_id;
        this.uid = uid;
        this.tid = tid;
        this.content = content;
        this.stardate = stardate;
        this.enddate= enddate;
        this.createtime = createtime;
        this.effect = effect;
        this.color = color;
        this.demo = demo;
        this.remark = remark;
    }

    public LED() {
        super();
    }

    public String getLed_id() {
        return Led_id;
    }

    public void setLed_id(String led_id) {
        this.Led_id = led_id;
    }

    public String getuid() {
        return uid;
    }

    public void setuid(String uid) {
        this.uid = uid;
    }

    public String gettid() {
        return tid;
    }

    public void settid(String tid) {
        this.tid = tid;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public String getstardate() {
        return stardate;
    }

    public void setstardate(String stardate) {
        this.stardate = stardate;
    }

    public String getenddate() {
        return enddate;
    }

    public void setenddate(String enddate) {
        this.enddate = enddate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getDemo() { return demo; }

    public void setDemo(String demo) { this.demo = demo; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }
}