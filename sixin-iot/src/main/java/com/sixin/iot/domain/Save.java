package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Save {
    @Excel(name="信号编号")
    private String info_id;
    @Excel(name="用户地址")
    private String user_adress;
    @Excel(name="报警状态",readConverterExp = "0=停用,1=正常")
    private String warnstatus;
    @Excel(name="接收状态",readConverterExp = "0=停用,1=正常")
    private String ray;
    @Excel(name="运行时间")
    private String runtime;


    @Override
    public String toString() {
        return "Save{" +
                "info_id='" + info_id + '\'' +
                ", user_adress='" + user_adress + '\'' +
                ", warnstatus='" + warnstatus + '\'' +
                ", ray='" + ray + '\'' +
                ", runtime='" + runtime + '\'' +
                '}';
    }

    public Save(String info_id, String user_adress, String ray, String warnstatus,String runtime) {
        this.info_id = info_id;
        this.user_adress = user_adress;
        this.ray = ray;
        this.warnstatus = warnstatus;
        this.runtime = runtime;
    }

    public Save() {
        super();
    }

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public String getUser_adress() {
        return user_adress;
    }

    public void setUser_adress(String user_adress) {
        this.user_adress = user_adress;
    }

    public String getRay() {
        return ray;
    }

    public void setRay(String ray) {
        this.ray = ray;
    }

    public String getWarnstatus() {
        return warnstatus;
    }

    public void setWarnstatus(String warnstatus) {
        this.warnstatus = warnstatus;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}