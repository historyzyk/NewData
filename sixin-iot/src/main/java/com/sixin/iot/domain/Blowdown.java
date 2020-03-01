package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Blowdown {
    @Excel(name="编号")
    private String pid;
    @Excel(name="监测时间")
    private String monitortime;
    @Excel(name="监测地点")
    private String location;
    @Excel(name="重金属含量")
    private String hmental;
    @Excel(name="PH值")
    private String ph;
    @Excel(name="电导率")
    private String econdu;
    @Excel(name="更新时间")
    private String updatetime;
    @Override
    public String toString() {
        return "Blowdown{" +
                "pid='" + pid + '\'' +
                ", monitortime='" + monitortime + '\'' +
                ", location='" + location + '\'' +
                ", hmental='" + hmental + '\'' +
                ", ph='" + ph + '\'' +
                ", econdu='" + econdu + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }

    public Blowdown(String pid, String monitortime, String location, String hmental, String ph, String econdu, String updatetime) {
        this.pid = pid;
        this.monitortime = monitortime;
        this.location = location;
        this.hmental = hmental;
        this.ph = ph;
        this.econdu = econdu;
        this.updatetime = updatetime;
    }
    public Blowdown() {
        super();
    }

    public String getpid() {
        return pid;
    }


    public void setpid(String pid) {
        this.pid = pid;
    }

    public String getmonitortime() {
        return monitortime;
    }
    public void setmonitortime(String monitortime) {
        this.monitortime = monitortime;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String gethmental() {
        return hmental;
    }
    public void sethmental(String hmental) {
        this.hmental = hmental;
    }
    public String getph() {
        return ph;
    }
    public void setph(String ph) {
        this.ph = ph;
    }
    public String getecondu() {
        return econdu;
    }
    public void setecondu(String econdu) {
        this.econdu = econdu;
    }
    public String getupdatetime() {
        return updatetime;
    }
    public void setupdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
