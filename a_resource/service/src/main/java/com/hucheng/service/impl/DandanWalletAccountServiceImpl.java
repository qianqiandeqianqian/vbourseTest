package com.hucheng.service.impl;

import com.hucheng.common.entity.DandanWalletAccount;
import com.hucheng.dao.DandanWalletAccountMapperDao;
import com.hucheng.service.DandanWalletAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: TODO
* @author xuchunlin
* @date 2018/1/3 11:03
* @version V1.0
*/
@Service
public class DandanWalletAccountServiceImpl implements DandanWalletAccountService {

    @Autowired
    private DandanWalletAccountMapperDao dandanWalletAccountMapperDao;

    public List<DandanWalletAccount> findList() throws Exception {
        return dandanWalletAccountMapperDao.findAll();
    }

    public int saveDandanWalletAccount(DandanWalletAccount dandanWalletAccount) throws Exception {
        return dandanWalletAccountMapperDao.insertSelective(dandanWalletAccount);
    }

    public DandanWalletAccount findAccountByUserId(Integer userId) throws Exception{
        DandanWalletAccount dandanWalletAccount=new DandanWalletAccount();
        dandanWalletAccount.setUserid(userId);
        return dandanWalletAccountMapperDao.find("findAccountByUserId",dandanWalletAccount);
    }
}