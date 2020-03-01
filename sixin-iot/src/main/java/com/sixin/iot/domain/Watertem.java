package com.sixin.iot.domain;

import com.sixin.common.core.domain.BaseEntity;

public class Watertem extends BaseEntity {
    private Integer tid;
    private String aid;
    private String tem;
    private String level;
    private String remark;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Watertem{" +
                "tid=" + tid +
                ", aid='" + aid + '\'' +
                ", tem='" + tem + '\'' +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
