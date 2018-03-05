package com.hucheng.service.impl;

import com.hucheng.common.entity.DandanUser;
import com.hucheng.dao.DandanUserMapperDao;
import com.hucheng.service.DandanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanAdminServiceImpl
 * @Package com.hucheng.service.impl
 * @Description: TODO
 * @date 2017/11/29 17:11
 */
@Service
public class DandanUserServiceImpl implements DandanUserService {

    @Autowired
    private DandanUserMapperDao dandanUserMapperDao;

    public DandanUser findByUsername(String username) throws Exception {
        return dandanUserMapperDao.find("findByUsername", new DandanUser(username));
    }

    public DandanUser findByUsernameAndPswd(String username, String password) throws Exception {
        return dandanUserMapperDao.find("findByUsernameAndPswd", new DandanUser(username, password));
    }

}
