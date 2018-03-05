package com.hucheng.rmi.codec;

import java.math.BigInteger;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: BalanceResult
 * @Package com.hucheng.rmi.codec
 * @Description: TODO
 * @date 2017/12/31 11:08
 */
public class BalanceResult extends  AbsTransactionResult{
    private BigInteger value;// 金额 单位wei

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
}
