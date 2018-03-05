package com.hucheng.rmi.codec;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: BalanceResult
 * @Package com.hucheng.rmi.codec
 * @Description: TODO
 * @date 2017/12/31 11:08
 */
public class AccountResult extends  AbsTransactionResult{
    private String createAddress;//创建的新地址

    public String getCreateAddress() {
        return createAddress;
    }

    public void setCreateAddress(String createAddress) {
        this.createAddress = createAddress;
    }
}
