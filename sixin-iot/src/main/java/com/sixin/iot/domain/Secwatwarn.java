package com.sixin.iot.domain;/* *
 * @Description:
 * @param $params$
 * @Return: $returns$
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/12/30 11:52
 * @开发版本：综合练习V0.1
 */

import java.util.Date;

public class Secwatwarn {
    private static final long serialVersionUID = 1L;

    private String stime;
    private String ndata;
    private String pdata;
    private String qdata;
    private String sdata;
    private String fudata;
    private String bacdata;

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getNdata() {
        return ndata;
    }

    public void setNdata(String ndata) {
        this.ndata = ndata;
    }

    public String getPdata() {
        return pdata;
    }

    public void setPdata(String pdata) {
        this.pdata = pdata;
    }

    public String getQdata() {
        return qdata;
    }

    public void setQdata(String qdata) {
        this.qdata = qdata;
    }

    public String getSdata() {
        return sdata;
    }

    public void setSdata(String sdata) {
        this.sdata = sdata;
    }

    public String getFudata() {
        return fudata;
    }

    public void setFudata(String fudata) {
        this.fudata = fudata;
    }

    public String getBacdata() {
        return bacdata;
    }

    public void setBacdata(String bacdata) {
        this.bacdata = bacdata;
    }

    @Override
    public String toString() {
        return "Secwatwarn{" +
                "stime='" + stime + '\'' +
                ", ndata='" + ndata + '\'' +
                ", pdata='" + pdata + '\'' +
                ", qdata='" + qdata + '\'' +
                ", sdata='" + sdata + '\'' +
                ", fudata='" + fudata + '\'' +
                ", bacdata='" + bacdata + '\'' +
                '}';
    }
}
