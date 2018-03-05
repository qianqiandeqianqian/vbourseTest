package com.hucheng.common.view;

import com.hucheng.common.entity.AbstractObject;

/**
 * 登录返回接口
 * @author xuchunlin
 * @version V1.0
 * @Title: VLoginRes
 * @Package com.hucheng.common.view
 * @Description: TODO
 * @date 2018/3/5 13:48
 */
public class VLoginRes extends AbstractObject{
    private Integer userid;
    private String username;
    private String email;
    private String mobile;
    private String invitecode;
    private long exp;//过期时间毫秒
    private String token;//认证token
    private String csrf;//CSRF令牌，用于

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCsrf() {
        return csrf;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }
}
