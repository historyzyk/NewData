package com.sixin.iot.domain;
import com.sixin.common.core.domain.BaseEntity;
import org.springframework.stereotype.Component;
import com.sixin.common.annotation.Excel;
//import javax.persistence.Id;
import com.sixin.common.annotation.Excel;

public class Sandbox extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Excel(name="开关编号")
    private String switch_id;
    @Excel(name="远程开关控制")
    private String control;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSwitch_id() {
        return switch_id;
    }

    public void setSwitch_id(String switch_id) {
        this.switch_id = switch_id;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return "Sandbox{" +
                "switch_id='" + switch_id + '\'' +
                ", control='" + control + '\'' +
                "} " + super.toString();
    }
}