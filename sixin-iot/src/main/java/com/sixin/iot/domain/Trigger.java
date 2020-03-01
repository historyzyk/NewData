package com.sixin.iot.domain;

import java.util.Date;

public class Trigger {
    private String id;
    private  String type;
    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Trigger{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                '}';
    }
}
