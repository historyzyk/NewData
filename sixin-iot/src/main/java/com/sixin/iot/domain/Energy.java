package com.sixin.iot.domain;

public class Energy {

    private String eid;

    private String bvoltage;

    private String bpvoltage;

    private String ccurrent;

    private String lcurrent;

    private String ovoltage;

    private String epsvoltage;

    private String svoltage;

    private String workingtemperature;

    private String cstate;

    private String workingstatu;

    @Override
    public String toString() {
        return "Energy{" +
                "eid='" + eid + '\'' +
                ", bvoltage='" + bvoltage + '\'' +
                ", bpvoltage='" + bpvoltage + '\'' +
                ", ccurrent='" + ccurrent + '\'' +
                ", lcurrent='" + lcurrent + '\'' +
                ", ovoltage='" + ovoltage + '\'' +
                ", epsvoltage='" + epsvoltage + '\'' +
                ", svoltage='" + svoltage + '\'' +
                ", workingtemperature='" + workingtemperature + '\'' +
                ", cstate='" + cstate + '\'' +
                ", workingstatu='" + workingstatu + '\'' +
                '}';
    }

    public Energy(String eid, String bvoltage, String bpvoltage, String ccurrent, String lcurrent, String ovoltage, String epsvoltage, String svoltage, String workingtemperature, String cstate, String workingstatu) {
        this.eid = eid;
        this.bvoltage = bvoltage;
        this.bpvoltage = bpvoltage;
        this.ccurrent = ccurrent;
        this.lcurrent = lcurrent;
        this.ovoltage = ovoltage;
        this.epsvoltage = epsvoltage;
        this.svoltage = svoltage;
        this.workingtemperature = workingtemperature;
        this.cstate = cstate;
        this.workingstatu = workingstatu;
    }

    public Energy() {
        super();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getBvoltage() {
        return bvoltage;
    }

    public void setBvoltage(String bvoltage) {
        this.bvoltage = bvoltage;
    }

    public String getBpvoltage() {
        return bpvoltage;
    }

    public void setBpvoltage(String bpvoltage) {
        this.bpvoltage = bpvoltage;
    }

    public String getCcurrent() {
        return ccurrent;
    }

    public void setCcurrent(String ccurrent) {
        this.ccurrent = ccurrent;
    }

    public String getLcurrent() {
        return lcurrent;
    }

    public void setLcurrent(String lcurrent) {
        this.lcurrent = lcurrent;
    }

    public String getOvoltage() {
        return ovoltage;
    }

    public void setOvoltage(String ovoltage) {
        this.ovoltage = ovoltage;
    }

    public String getEpsvoltage() {
        return epsvoltage;
    }

    public void setEpsvoltage(String epsvoltage) {
        this.epsvoltage = epsvoltage;
    }

    public String getSvoltage() {
        return svoltage;
    }

    public void setSvoltage(String svoltage) {
        this.svoltage = svoltage;
    }

    public String getWorkingtemperature() {
        return workingtemperature;
    }

    public void setWorkingtemperature(String workingtemperature) {
        this.workingtemperature = workingtemperature;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public String getWorkingstatu() {
        return workingstatu;
    }

    public void setWorkingstatu(String workingstatu) {
        this.workingstatu = workingstatu;
    }
}