package com.hucheng.common.entity;

import java.math.BigDecimal;

public class SysUserCoin extends AbstractObject{
    private Integer ucid;

    private Integer userid;

    private String coincode;

    private BigDecimal num;

    private BigDecimal numd;

    private String numaddr;

    private String coinsign;

    private Integer isexception;

    public Integer getUcid() {
        return ucid;
    }

    public void setUcid(Integer ucid) {
        this.ucid = ucid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCoincode() {
        return coincode;
    }

    public void setCoincode(String coincode) {
        this.coincode = coincode == null ? null : coincode.trim();
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getNumd() {
        return numd;
    }

    public void setNumd(BigDecimal numd) {
        this.numd = numd;
    }

    public String getNumaddr() {
        return numaddr;
    }

    public void setNumaddr(String numaddr) {
        this.numaddr = numaddr == null ? null : numaddr.trim();
    }

    public String getCoinsign() {
        return coinsign;
    }

    public void setCoinsign(String coinsign) {
        this.coinsign = coinsign == null ? null : coinsign.trim();
    }

    public Integer getIsexception() {
        return isexception;
    }

    public void setIsexception(Integer isexception) {
        this.isexception = isexception;
    }
}