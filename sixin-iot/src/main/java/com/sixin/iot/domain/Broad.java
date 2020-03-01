package com.sixin.iot.domain;

import com.sixin.common.annotation.Excel;

public class Broad {
    @Excel(name="广播编号")
    private String broad_id;
    @Excel(name="设备地址")
    private String address;
    @Excel(name="运行状态",readConverterExp = "0=停用,1=正常")
    private String statue;
    @Excel(name="运行时间")
    private String runtime;
    @Excel(name="广播状态")
    private String details;

    @Override
    public String toString() {
        return "Broad{" +
                "broad_id='" + broad_id + '\'' +
                ", address='" + address + '\'' +
                ", statue='" + statue + '\'' +
                ", runtime='" + runtime + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public Broad(String broad_id, String address, String statue, String runtime, String details) {
        this.broad_id = broad_id;
        this.address = address;
        this.statue = statue;
        this.runtime = runtime;
        this.details = details;
    }

    public Broad() {
        super();
    }

    public String getBroad_id() {
        return broad_id;
    }

    public void setBroad_id(String broad_id) {
        this.broad_id = broad_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
