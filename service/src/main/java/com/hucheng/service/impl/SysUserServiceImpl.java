package com.hucheng.service.impl;

import com.hucheng.common.entity.SysUser;
import com.hucheng.dao.SysUserMapperDao;
import com.hucheng.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapperDao sysUserMapperDao;

    public SysUser findUserByUsernameAndPswd(String username, String password) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        return sysUserMapperDao.find("findUser",sysUser);
    }

    public SysUser findUserByEmailAndPswd(String email, String password) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setEmail(email);
        sysUser.setPassword(password);
        return sysUserMapperDao.find("findUser",sysUser);
    }

    public SysUser findUserByMobileAndPswd(String mobile, String password) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setMobile(mobile);
        sysUser.setPassword(password);
        return sysUserMapperDao.find("findUser",sysUser);
    }

    public int addSysUser(SysUser sysUser) throws Exception {
        return sysUserMapperDao.insert(sysUser);
    }
}
