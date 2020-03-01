package com.sixin.village.domain;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
public class Warnset {
    private Long id;
    private Long deptId;
    private String wtype;
    private float mvalue;
    private float svalue;
    private String warn1;
    private String warn2;
    private int wrating;
    private int remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype;
    }

    public float getMvalue() {
        return mvalue;
    }

    public void setMvalue(float mvalue) {
        this.mvalue = mvalue;
    }

    public float getSvalue() {
        return svalue;
    }

    public void setSvalue(float svalue) {
        this.svalue = svalue;
    }

    public String getWarn1() {
        return warn1;
    }

    public void setWarn1(String warn1) {
        this.warn1 = warn1;
    }

    public String getWarn2() {
        return warn2;
    }

    public void setWarn2(String warn2) {
        this.warn2 = warn2;
    }

    public int getWrating() {
        return wrating;
    }

    public void setWrating(int wrating) {
        this.wrating = wrating;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }
}
