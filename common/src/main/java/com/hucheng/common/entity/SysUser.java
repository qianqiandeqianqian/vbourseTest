package com.hucheng.common.entity;

import java.util.Date;

public class SysUser extends AbstractObject{
    private Integer userid;

    private String showname;

    private String username;

    private String email;

    private String mobile;

    private String password;

    private String paypassword;

    private String idcard;

    private Date regtime;

    private String ip;

    private String sign;

    private Integer status;

    private String invitecode;

    private String invite1;

    private String invite2;

    private String invite3;

    private Integer creditlevel;

    private Integer isdeleted;

    private String remark;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname == null ? null : showname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword == null ? null : paypassword.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode == null ? null : invitecode.trim();
    }

    public String getInvite1() {
        return invite1;
    }

    public void setInvite1(String invite1) {
        this.invite1 = invite1 == null ? null : invite1.trim();
    }

    public String getInvite2() {
        return invite2;
    }

    public void setInvite2(String invite2) {
        this.invite2 = invite2 == null ? null : invite2.trim();
    }

    public String getInvite3() {
        return invite3;
    }

    public void setInvite3(String invite3) {
        this.invite3 = invite3 == null ? null : invite3.trim();
    }

    public Integer getCreditlevel() {
        return creditlevel;
    }

    public void setCreditlevel(Integer creditlevel) {
        this.creditlevel = creditlevel;
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