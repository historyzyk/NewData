package com.sixin.village.domain;

/**
 * @开发人员: 申超豪
 * @开发单位：湖南农业大学物联网工程专业
 * @Description:
 * @Date:
 */
public class Statistics {
    private String valueid;
    private String valuename;
    private short issingleselection;

    public String getValueid() {
        return valueid;
    }

    public void setValueid(String valueid) {
        this.valueid = valueid;
    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename;
    }

    public short getIssingleselection() {
        return issingleselection;
    }

    public void setIssingleselection(short issingleselection) {
        this.issingleselection = issingleselection;
    }
}
