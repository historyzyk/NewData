package com.sixin.iot.domain;

import com.sixin.common.core.domain.BaseEntity;
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Repository;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */
@Repository
public class MetSum extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String data;
    private String temp;
    private String sumtemp;
    private String hum;
    private String sumhum;
    private String rname;
    private String sumrain;
    private String countrain;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getSumhum() {
        return sumhum;
    }

    public void setSumhum(String sumhum) {
        this.sumhum = sumhum;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getSumrain() {
        return sumrain;
    }

    public void setSumrain(String sumrain) {
        this.sumrain = sumrain;
    }

    public String getCountrain() {
        return countrain;
    }

    public void setCountrain(String countrain) {
        this.countrain = countrain;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSumtemp() {
        return sumtemp;
    }

    public void setSumtemp(String sumtemp) {
        this.sumtemp = sumtemp;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MetSum{" +
                "data='" + data + '\'' +
                ", temp='" + temp + '\'' +
                ", sumtemp='" + sumtemp + '\'' +
                ", hum='" + hum + '\'' +
                ", sumhum='" + sumhum + '\'' +
                ", rname='" + rname + '\'' +
                ", sumrain='" + sumrain + '\'' +
                ", countrain='" + countrain + '\'' +
                '}';
    }
}
