package com.hucheng.service;

import com.hucheng.common.entity.DandanEthTransfer;
import com.hucheng.common.view.WalletUser;

import java.util.List;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanUserService
 * @Package com.hucheng.service
 * @Description: TODO
 * @date 2017/11/28 16:10
 */
public interface DandanEthTransferService {

    /**
     * 保存交易记录
    * @Description: TODO
    * @author xuchunlin
    * @date 2018/1/2 10:32
    * @version V1.0
    */
    int saveDandanEthTransfer(DandanEthTransfer dandanEthTransfer) throws Exception;

    int updateByTransfer(DandanEthTransfer dandanEthTransfer) throws Exception;

    int updateByTransactionHash(DandanEthTransfer dandanEthTransfer) throws Exception;

    void updateByTransactionHash(List<DandanEthTransfer> dandanEthTransfer) throws Exception;
    /**
     * 根据hash查询对应的记录
     * @param transactionHash
     * @return
     * @throws Exception
     */
    DandanEthTransfer findDandanEthTransferByTransactionHash(String transactionHash) throws Exception;

    /**
     * 查询所有自动到账未修改账户金额的记录，状态类型为2
     * @return
     * @throws Exception
     */
    List<DandanEthTransfer> findDandanEthTransferFinishList() throws Exception;

    /**
     * 查询类型成功入账单未转入到系统账户的记录
     * @return
     * @throws Exception
     */
    List<WalletUser> findDandanEthTransferNoToMainList() throws  Exception;

    /**
     * 成功转入系统账户的记录执行账户金额修改和插入新的转入记录
     * @param id
     * @throws Exception
     */
    void executeTransferAutoAddCoin(Integer id) throws Exception;
}
