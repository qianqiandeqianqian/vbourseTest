package com.hucheng.service;

import com.hucheng.common.entity.DandanAdmin;

import java.util.List;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanUserService
 * @Package com.hucheng.service
 * @Description: TODO
 * @date 2017/11/28 16:10
 */
public interface DandanAdminService{

    /**
    * @Description: 根据用户名和密码查询个人信息
    * @author xuchunlin
    * @date 2017/11/29 17:13
    * @version V1.0
    */
    DandanAdmin findByUsername(String username) throws Exception;

    /**
    * @Description: 根据用户名和密码查询用户
    * @author xuchunlin
    * @date 2017/11/29 17:24
    * @version V1.0
    */
    DandanAdmin findByUsernameAndPswd(String username, String password) throws Exception;

}
