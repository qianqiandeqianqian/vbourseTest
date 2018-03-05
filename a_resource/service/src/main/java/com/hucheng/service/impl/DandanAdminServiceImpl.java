package com.hucheng.service.impl;

import com.hucheng.common.entity.DandanAdmin;
import com.hucheng.dao.DandanAdminMapperDao;
import com.hucheng.service.DandanAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanAdminServiceImpl
 * @Package com.hucheng.service.impl
 * @Description: TODO
 * @date 2017/11/29 17:11
 */
@Service
public class DandanAdminServiceImpl  implements DandanAdminService{

    @Autowired
    private DandanAdminMapperDao dandanAdminMapperDao;

    public DandanAdmin findByUsername(String username) throws Exception {
        return dandanAdminMapperDao.find("findByUsername", new DandanAdmin(username));
    }

    public DandanAdmin findByUsernameAndPswd(String username, String password) throws Exception {
        return dandanAdminMapperDao.find("findByUsernameAndPswd", new DandanAdmin(username, password));
    }

}
