package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Soil {
    @Excel(name = "编号")
    private String sid;
    @Excel(name = "类型")
    private String type;
    @Excel(name = "地域")
    private String area;
    @Excel(name = "探测深度(/m)")
    private String depth;
    @Excel(name = "酸碱度")
    private String ph;
    @Excel(name = "水分%")
    private String water;
    @Excel(name = "盐分%")
    private String sailnity;
    @Excel(name = "有机质%")
    private String organic;
    @Excel(name = "创建者")
    private String creator;
    @Excel(name = "创建时间")
    private String creatime;

    @Override
    public String toString() {
        return "Soil{" +
                "sid='" + sid + '\'' +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", depth='" + depth + '\'' +
                ", ph='" + ph + '\'' +
                ", water='" + water + '\'' +
                ", sailnity='" + sailnity + '\'' +
                ", organic='" + organic + '\'' +
                ", creator='" + creator + '\'' +
                ", creatime='" + creatime + '\'' +
                '}';



    }

    public Soil(String sid, String type, String area, String depth, String ph, String water, String sailnity, String organic, String creator, String creatime) {
        this.sid = sid;
        this.type = type;
        this.area = area;
        this.depth = depth;
        this.ph = ph;
        this.water = water;
        this.sailnity = sailnity;
        this.organic = organic;
        this.creator = creator;
        this.creatime = creatime;
    }

    public Soil() {
        super();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getSailnity() {
        return sailnity;
    }

    public void setSailnity(String sailnity) {
        this.sailnity = sailnity;
    }

    public String getOrganic() {
        return organic;
    }

    public void setOrganic(String organic) {
        this.organic = organic;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatime() { return creatime; }

    public void setCreatime(String creatime) {
        this.creatime = creatime;
    }
}