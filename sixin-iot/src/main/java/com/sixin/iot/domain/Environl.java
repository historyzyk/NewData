package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Environl {
    @Excel(name="编号")
    private String hid;
    @Excel(name="环境温度")
    private String temperature;
    @Excel(name="环境湿度")
    private String humidity;
    @Excel(name="风速")
    private String speed;
    @Excel(name="风向")
    private String direction;
    @Excel(name="光照强度")
    private String intensity;
    @Excel(name="大气压强")
    private String pressure;
    @Excel(name="PM2.5浓度")
    private String pm;
    @Excel(name="二氧化碳浓度")
    private String ppm;
    @Excel(name="设备状态（0-关，1-开）")
    private String status;
    @Override
    public String toString() {
        return "Environl{" +
                "hid='" + hid + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", speed='" + speed + '\'' +
                ", direction='" + direction + '\'' +
                ", intensity='" + intensity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", pm='" + pm + '\'' +
                ", ppm='" + ppm + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Environl(String hid, String temperature, String humidity, String speed, String direction, String intensity, String pressure, String pm, String ppm, String status) {
        this.hid = hid;
        this.temperature = temperature;
        this.humidity = humidity;
        this.speed = speed;
        this.direction = direction;
        this.intensity = intensity;
        this.pressure = pressure;
        this.pm = pm;
        this.ppm = ppm;
        this.status = status;
    }
    public Environl() {
        super();
    }

    public String gethid() {
        return hid;
    }

    public void sethid(String hid) {
        this.hid = hid;
    }

    public String gettemperature() {
        return temperature;
    }
    public void settemperature(String temperature) {
        this.temperature = temperature;
    }
    public String gethumidity() {
        return humidity;
    }
    public void sethumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getspeed() {
        return speed;
    }
    public void setspeed(String speed) {
        this.speed = speed;
    }
    public String getdirection() {
        return direction;
    }
    public void setdirection(String direction) {
        this.direction = direction;
    }
    public String getintensity() {
        return intensity;
    }
    public void setintensity(String intensity) {
        this.intensity = intensity;
    }
    public String getpressure() {
        return pressure;
    }
    public void setpressure(String pressure) {
        this.pressure = pressure;
    }
    public String getpm() {
        return pm;
    }
    public void setpm(String pm) {
        this.pm = pm;
    }
    public String getppm() {
        return ppm;
    }
    public void setppm(String ppm) {
        this.ppm = ppm;
    }
    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }
}