package com.hucheng.common.bean;

import java.io.Serializable;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: AdminUser
 * @Package com.hucheng.common.bean
 * @Description: 后台登录对象
 * @date 2017/11/29 14:25
 */
public abstract class AdminUser implements Serializable{

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
