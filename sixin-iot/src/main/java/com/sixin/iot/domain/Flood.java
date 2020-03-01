package com.sixin.iot.domain;

import com.sixin.common.annotation.Excels;
import com.sixin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;
import com.sixin.common.annotation.Excel;
public class Flood  extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Excel(name="数据编号")
    private String id;
    @Excel(name="数据类型")
    private String type;
    @Excel(name="地域编号")
    private String rid;
    @Excel(name="地域名称")
    private String rname;
    @Excel(name="数据大小")
    private String data;
    @Excel(name="采集日期时间")
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Flood{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", rid='" + rid + '\'' +
                ", rname='" + rname + '\'' +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                "} " + super.toString();
    }
}