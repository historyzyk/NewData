package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Water {
    @Excel(name = "编号")
    private String wid;
    @Excel(name = "类型")
    private String type;
    @Excel(name = "地域")
    private String area;
    @Excel(name = "温度℃")
    private String temperature;
    @Excel(name = "色度%")
    private String color;
    @Excel(name = "浊度%")
    private String turbidity;
    @Excel(name = "酸碱度")
    private String ph;
    @Excel(name = "电导率(西门子/米)")
    private String electric;
    @Excel(name = "悬浮物")
    private String seston;
    @Excel(name = "溶解氧")
    private String oxygen;
    @Excel(name = "有毒物质")
    private String poison;
    @Excel(name = "创建者")
    private String creator;
    @Excel(name = "创建时间")
    private String creatime;

    @Override
    public String toString() {
        return "Water{" +
                "wid='" + wid + '\'' +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", temperature='" + temperature + '\'' +
                ", color='" + color + '\'' +
                ", turbidity='" + turbidity + '\'' +
                ", ph='" + ph + '\'' +
                ", electric='" + electric + '\'' +
                ", seston='" + seston + '\'' +
                ", oxygen='" + oxygen + '\'' +
                ", poison='" + poison + '\'' +
                ", creator='" + creator + '\'' +
                ", creatime='" + creatime + '\'' +
                '}';
    }

    public Water(String wid, String type, String area, String temperature, String color, String turbidity, String ph, String electric, String seston, String oxygen, String poison, String creator, String creatime) {
        this.wid = wid;
        this.type = type;
        this.area = area;
        this.temperature = temperature;
        this.color = color;
        this.turbidity = turbidity;
        this.ph = ph;
        this.electric = electric;
        this.seston = seston;
        this.oxygen = oxygen;
        this.poison = poison;
        this.creator = creator;
        this.creatime = creatime;
    }

    public Water() {
        super();
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric;
    }

    public String getSeston() {
        return seston;
    }

    public void setSeston(String seston) {
        this.seston = seston;
    }

    public String getOxygen() {
        return oxygen;
    }

    public void setOxygen(String oxygen) {
        this.oxygen = oxygen;
    }

    public String getPoison() {
        return poison;
    }

    public void setPoison(String poison) {
        this.poison = poison;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatime() {
        return creatime;
    }

    public void setCreatime(String creatime)
    { this.creatime = creatime;
    }
}
