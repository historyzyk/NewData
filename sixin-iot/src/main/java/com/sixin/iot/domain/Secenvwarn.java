package com.sixin.iot.domain;/* *
 * @Description:定义安防表属性
 * @param $params$
 * @Return: $returns$
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/12/28 18:02
 * @开发版本：综合练习V0.1
 */

import com.sixin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.math.BigDecimal;

public class Secenvwarn extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private int mid;
    private String pm;
    private String rain;
    private String time;
    private String temp;
    private String wlevel;
    private String hum;
    private String content;
    private String aid;
    private long secnum;



    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWlevel() {
        return wlevel;
    }

    public void setWlevel(String wlevel) {
        this.wlevel = wlevel;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSecnum() {
        return secnum;
    }

    public void setSecnum(long secnum) {
        this.secnum = secnum;
    }

    @Override
    public String toString() {
        return "Secenvwarn{" +
                "mid=" + mid +
                ", pm='" + pm + '\'' +
                ", rain='" + rain + '\'' +
                ", time='" + time + '\'' +
                ", temp='" + temp + '\'' +
                ", wlevel='" + wlevel + '\'' +
                ", hum='" + hum + '\'' +
                ", content='" + content + '\'' +
                ", aid='" + aid + '\'' +
                ", secnum=" + secnum +
                '}';
    }
}
