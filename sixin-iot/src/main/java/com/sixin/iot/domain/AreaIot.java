package com.sixin.iot.domain;
/**
 * @function:物联网区域
 * @Systemname:融媒体数据管理综合服务平台
 * @Author:申超豪
 * @Description:
 * @Date:Created in 2020-01-27 17:40
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:融媒体数据管理综合服务平台V3.2.0
 * @Rewriting:刘波
 */
import com.sixin.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AreaIot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地域ID */
    private String aid;
    /** 父地域ID */
    private String parentaid;
    /** 地域名称 */
    private String aname;
    /** 备注 */
    private String note;

    public void setAid(String aid)
    {
        this.aid = aid;
    }

    public String getAid()
    {
        return aid;
    }
    public void setParentaid(String parentaid)
    {
        this.parentaid = parentaid;
    }

    public String getParentaid()
    {
        return parentaid;
    }
    public void setAname(String aname)
    {
        this.aname = aname;
    }

    public String getAname()
    {
        return aname;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("aid", getAid())
                .append("parentaid", getParentaid())
                .append("aname", getAname())
                .append("note", getNote())
                .toString();
    }
}
