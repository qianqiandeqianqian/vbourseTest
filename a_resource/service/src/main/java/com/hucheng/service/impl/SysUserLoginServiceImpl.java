package com.hucheng.service.impl;

import com.hucheng.common.entity.SysUser;
import com.hucheng.dao.SysUserLoginMapperDao;
import com.hucheng.service.SysUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

    @Autowired
    SysUserLoginMapperDao sysUserLoginMapperDao;

    public SysUser accordUsernameLogin(SysUser sysUser) throws Exception {
        return sysUserLoginMapperDao.accordUsernameLogin(sysUser);
    }

    public SysUser accordMobileLogin(SysUser sysUser) throws Exception {
        return sysUserLoginMapperDao.accordMobileLogin(sysUser);
    }

    public SysUser accordEmailLogin(SysUser sysUser) throws Exception {
        return sysUserLoginMapperDao.accordEmailLogin(sysUser);
    }

    public int register(SysUser sysUser) throws Exception {
        return sysUserLoginMapperDao.register(sysUser);
    }
}
