package com.hucheng.rmi.service;

import com.hucheng.rmi.codec.AbsTransactionResult;
import com.hucheng.rmi.codec.RMIResponse;
import com.hucheng.rmi.coin.EnumCoin;

import java.math.BigInteger;

/**
 * 钱包服务接口
 * @author xuchunlin
 * @version V1.0
 * @Title: RmiInterface
 * @Package com.hucheng.wallet.rmi
 * @Description: TODO
 * @date 2017/12/27 11:24
 */
public interface RmiWalletInterface {
    /**
     * 向某地址转入合约币,
     * @param enumCoin 合约币类型
     * @param toAddress 对方地址
     * @param bigInteger 转账金额 wei
     * @param gasPrice 手续费
     * @return
     */
    RMIResponse<? super AbsTransactionResult> transfer(EnumCoin enumCoin, String toAddress, BigInteger bigInteger, BigInteger gasPrice);

    /**
     * 获取某合约某地址钱包
     * @param enumCoin 合约币类型
     * @param toAddress 对方地址
     * @return
     */
    RMIResponse<? super AbsTransactionResult> getBalance(EnumCoin enumCoin, String toAddress);

    /**
     * 获取某合约主账号钱包余额
     * @param enumCoin 合约币类型
     * @return
     */
    RMIResponse<? super AbsTransactionResult> getBalance(EnumCoin enumCoin);

    /**
     * 创建以太坊钱包
     * @param userId 绑定的用户ID
     * @return 账户地址accountId
     */
    RMIResponse<? super AbsTransactionResult> createAccount(Integer userId);

    /**
     * 平台内账户from向to转账
     * @param from 转账人地址
     * @param to 收账人地址
     * @param value 转入金额
     * @param gasPrice 手续费
     * @return
     */
    RMIResponse<? super AbsTransactionResult> transferFrom(EnumCoin enumCoin,String from,String to,BigInteger value,BigInteger gasPrice);
}
