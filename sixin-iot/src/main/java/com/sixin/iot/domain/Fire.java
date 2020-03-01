package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Fire {
    @Excel(name = "编号")
    private String fid;
    @Excel(name = "设备状态",readConverterExp="0=停用,1=正常")
    private String dstatus;
    @Excel(name = "环境温度℃")
    private String temperature;
    @Excel(name = "二氧化碳浓度%")
    private String ppm;
    @Excel(name = "pm2.5浓度%")
    private String pm;
    @Excel(name = "电流检测(mA)")
    private String eletric;
    @Override
    public String toString() {
        return "Fire{" +
                "fid='" + fid + '\'' +
                ", dstatus='" + dstatus + '\'' +
                ", temperature='" + temperature + '\'' +
                ", ppm='" + ppm + '\'' +
                ", pm='" + pm + '\'' +
                ", eletric='" + eletric + '\'' +
                '}';
    }

    public Fire(String fid, String dstatus, String temperature, String ppm, String pm, String eletric) {
        this.fid = fid;
        this.dstatus = dstatus;
        this.temperature = temperature;
        this.ppm = ppm;
        this.pm = pm;
        this.eletric = eletric;
    }
    public Fire() {
        super();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getDstatus() { return dstatus; }
    public void setDstatus(String dstatus) {
        this.dstatus = dstatus;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getPpm() {
        return ppm;
    }
    public void setPpm(String ppm) {
        this.ppm = ppm;
    }
    public String getPm() {
        return pm;
    }
    public void setPm(String pm) {
        this.pm = pm;
    }
    public String getEletric() {
        return eletric;
    }
    public void setEletric(String eletric) {
        this.eletric = eletric;
    }
}