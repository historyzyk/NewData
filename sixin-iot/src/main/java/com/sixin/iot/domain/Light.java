package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Light {
    @Excel(name = "路灯编号")
    private String nid;
    @Excel(name = "环境温度")
    private String atemperature;
    @Excel(name = "风速")
    private String windspeed;
    @Excel(name = "工作电流")
    private String current;
    @Excel(name = "工作电压")
    private String voltage;
    @Excel(name = "亮灯时间")
    private String tstart;
    @Excel(name = "熄灯时间")
    private String tdown;

    @Override
    public String toString() {
        return "Light{" +
                "nid='" + nid + '\'' +
                ", atemperature='" + atemperature + '\'' +
                ", windspeed='" + windspeed + '\'' +
                ", current='" + current + '\'' +
                ", voltage='" + voltage + '\'' +
                ", tstart='" + tstart + '\'' +
                ", tdown='" + tdown + '\'' +
                '}';
    }

    public Light(String nid, String atemperature, String windspeed, String current, String voltage, String tstart, String tdown) {
        this.nid = nid;
        this.atemperature = atemperature;
        this.windspeed = windspeed;
        this.current = current;
        this.voltage = voltage;
        this.tstart = tstart;
        this.tdown = tdown;
    }

    public Light() {
        super();
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getAtemperature() {
        return atemperature;
    }

    public void setAtemperature(String atemperature) {
        this.atemperature = atemperature;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getTstart() {
        return tstart;
    }

    public void setTstart(String tstart) {
        this.tstart = tstart;
    }

    public String getTdown() {
        return tdown;
    }

    public void setTdown(String tdown) {
        this.tdown = tdown;
    }
}