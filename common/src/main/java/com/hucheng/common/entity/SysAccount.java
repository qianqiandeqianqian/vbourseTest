package com.hucheng.common.entity;

import java.util.Date;

public class SysAccount extends AbstractObject{
    private Integer accountid;

    private String name;

    private String username;

    private String password;

    private String email;

    private String mobile;

    private Date regtime;

    private String ip;

    private Date btime;

    private Integer status;

    private Integer lgcount;

    private Integer ercount;

    private String ertext;

    private Integer isdeleted;

    private String remark;

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLgcount() {
        return lgcount;
    }

    public void setLgcount(Integer lgcount) {
        this.lgcount = lgcount;
    }

    public Integer getErcount() {
        return ercount;
    }

    public void setErcount(Integer ercount) {
        this.ercount = ercount;
    }

    public String getErtext() {
        return ertext;
    }

    public void setErtext(String ertext) {
        this.ertext = ertext == null ? null : ertext.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}