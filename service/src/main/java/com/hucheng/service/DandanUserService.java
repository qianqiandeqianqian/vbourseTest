package com.hucheng.service;

import com.hucheng.common.entity.DandanUser;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanUserService
 * @Package com.hucheng.service
 * @Description: TODO
 * @date 2017/11/28 16:10
 */
public interface DandanUserService {

    /**
     * 根据用户名或密码查询用户信息
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    DandanUser findByUsernameAndPswd(String username, String password) throws Exception;
}
