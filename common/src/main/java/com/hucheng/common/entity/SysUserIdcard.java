package com.hucheng.common.entity;

import java.util.Date;

public class SysUserIdcard extends AbstractObject{
    private Integer icid;

    private Integer userid;

    private String enname;

    private String usname;

    private String type;

    private String idcard;

    private String ximg;

    private String yimg;

    private String zimg;

    private Date time;

    private Date audittime;

    private Integer accountid;

    private Integer status;

    private Integer isdeleted;

    public Integer getIcid() {
        return icid;
    }

    public void setIcid(Integer icid) {
        this.icid = icid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname == null ? null : usname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getXimg() {
        return ximg;
    }

    public void setXimg(String ximg) {
        this.ximg = ximg == null ? null : ximg.trim();
    }

    public String getYimg() {
        return yimg;
    }

    public void setYimg(String yimg) {
        this.yimg = yimg == null ? null : yimg.trim();
    }

    public String getZimg() {
        return zimg;
    }

    public void setZimg(String zimg) {
        this.zimg = zimg == null ? null : zimg.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }
}