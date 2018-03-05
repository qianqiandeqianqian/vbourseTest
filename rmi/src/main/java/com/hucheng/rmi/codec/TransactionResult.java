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
public class TransactionResult extends  AbsTransactionResult{

    private BigInteger value;// 金额 单位wei
    private String transactionHash; //事物hash
    private String from; //转账者地址
    private String to; //收款者地址
    private String contractAddress;//合约地址
    private BigInteger gasUsed;//消耗的挖矿费 单位wei

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigInteger getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(BigInteger gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }
}
