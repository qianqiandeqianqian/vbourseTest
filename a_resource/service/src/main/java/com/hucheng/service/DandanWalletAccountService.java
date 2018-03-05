package com.hucheng.service;

import com.hucheng.common.entity.DandanWalletAccount;

import java.util.List;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanWalletAccountService
 * @Package com.hucheng.service
 * @Description: TODO
 * @date 2017/11/28 16:10
 */
public interface DandanWalletAccountService {

    List<DandanWalletAccount> findList() throws Exception;

    int saveDandanWalletAccount(DandanWalletAccount dandanWalletAccount) throws Exception;

    DandanWalletAccount findAccountByUserId(Integer userId) throws Exception;
}
