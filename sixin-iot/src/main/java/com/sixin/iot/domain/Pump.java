package com.sixin.iot.domain;

public class Pump {

    private String id;

    private String tid;

    private String pcurrent;

    private String pvoltage;

    private String wlheight;

    private String wlpressure;

    @Override
    public String toString() {
        return "Pump{" +
                "id='" + id + '\'' +
                ", tid='" + tid + '\'' +
                ", pcurrent='" + pcurrent + '\'' +
                ", pvoltage='" + pvoltage + '\'' +
                ", wlheight='" + wlheight + '\'' +
                ", wlpressure='" + wlpressure + '\'' +
                '}';
    }

    public Pump(String id, String tid, String pcurrent, String pvoltage, String wlheight, String wlpressure) {
        this.id = id;
        this.tid = tid;
        this.pcurrent = pcurrent;
        this.pvoltage = pvoltage;
        this.wlheight = wlheight;
        this.wlpressure = wlpressure;
    }

    public Pump() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getpcurrent() {
        return pcurrent;
    }

    public void setpcurrent(String pcurrent) {
        this.pcurrent = pcurrent;
    }

    public String getpvoltage() {
        return pvoltage;
    }

    public void setpvoltage(String pvoltage) {
        this.pvoltage = pvoltage;
    }

    public String getwlheight() {
        return wlheight;
    }

    public void setwlheight(String wlheight) {
        this.wlheight = wlheight;
    }

    public String getwlpressure() {
        return wlpressure;
    }

    public void setwlpressure(String wlpressure) {
        this.wlpressure = wlpressure;
    }
}
