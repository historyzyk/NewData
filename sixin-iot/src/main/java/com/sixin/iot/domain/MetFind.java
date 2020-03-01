package com.sixin.iot.domain;

import com.sixin.common.core.domain.BaseEntity;
import org.springframework.stereotype.Repository;

/**
 * @开发人员：周宇滔
 * @开发单位：湖南农业大学物联网工程专业
 */

@Repository
public class MetFind extends BaseEntity {

    private static final long serialVersionUID = 1L;


    private String id;
    private String rname;
    private String data;
    private String time;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "MetFind{" +
                "id='" + id + '\'' +
                ", rname='" + rname + '\'' +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
