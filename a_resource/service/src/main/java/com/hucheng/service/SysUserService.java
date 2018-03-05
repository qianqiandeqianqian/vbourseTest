package com.hucheng.service;

import com.hucheng.common.entity.SysUser;

public interface SysUserService {

    /**
     * @Description 根据用户名登录
     * @author liangxiaoyi
     * @param username
     * @param password
     */
    SysUser findUserByUsernameAndPswd(String username,String password) throws Exception;

    /**
     * @Description 根据邮箱登录
     * @author liangxiaoyi
     * @param email
     * @param password
     */
    SysUser findUserByEmailAndPswd(String email,String password) throws Exception;

    /**
     * @Description 根据手机号码登录
     * @author liangxiaoyi
     * @param mobile
     * @param password
     */
    SysUser findUserByMobileAndPswd(String mobile,String password) throws Exception;

    /**
     * @Description 用户注册
     * @author liangxiaoyi
     * @param sysUser(mobile password invitecode paypassword)
     */
    int register(SysUser sysUser) throws Exception;
}
