package com.sixin.iot.domain;

import java.util.Date;

public class SoilDevice {
    private int did;
    private String dname;
    private  int dstatus;
    private int dv;
    private Date dctime;
    private Date dftime;
    private String dcname;
    private String  dfname;
    private String note;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDstatus() {
        return dstatus;
    }

    public void setDstatus(int dstatus) {
        this.dstatus = dstatus;
    }

    public int getDv() {
        return dv;
    }

    public void setDv(int dv) {
        this.dv = dv;
    }

    public Date getDctime() {
        return dctime;
    }

    public void setDctime(Date dctime) {
        this.dctime = dctime;
    }

    public Date getDftime() {
        return dftime;
    }

    public void setDftime(Date dftime) {
        this.dftime = dftime;
    }

    public String getDcname() {
        return dcname;
    }

    public void setDcname(String dcname) {
        this.dcname = dcname;
    }

    public String getDfname() {
        return dfname;
    }

    public void setDfname(String dfname) {
        this.dfname = dfname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "SoilDevice{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dstatus=" + dstatus +
                ", dv=" + dv +
                ", dctime=" + dctime +
                ", dftime=" + dftime +
                ", dcname='" + dcname + '\'' +
                ", dfname='" + dfname + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
