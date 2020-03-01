package com.sixin.iot.domain;

import java.util.Date;

public class SoilWater {
    private static final long serialVersionUID = 1L;
//    地域名
    private String dname;
//    含水量
    private String water;
//    地点
    private String where;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //日期
    private Date date;
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "SoilWater{" +
                "dname='" + dname + '\'' +
                ", water='" + water + '\'' +
                ", where='" + where + '\'' +
                ", date=" + date +
                '}';
    }
}
