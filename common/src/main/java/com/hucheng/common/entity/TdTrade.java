package com.hucheng.common.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TdTrade extends AbstractObject{
    private Integer tdid;

    private Integer userid;

    private String coincode;

    private BigDecimal price;

    private BigDecimal num;

    private BigDecimal deal;

    private String gCoincode;

    private BigDecimal gnum;

    private String fCoincode;

    private BigDecimal fnum;

    private Integer type;

    private Date tradetime;

    private Date dealtime;

    private Integer status;

    private String tradesign;

    public Integer getTdid() {
        return tdid;
    }

    public void setTdid(Integer tdid) {
        this.tdid = tdid;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getDeal() {
        return deal;
    }

    public void setDeal(BigDecimal deal) {
        this.deal = deal;
    }

    public String getgCoincode() {
        return gCoincode;
    }

    public void setgCoincode(String gCoincode) {
        this.gCoincode = gCoincode == null ? null : gCoincode.trim();
    }

    public BigDecimal getGnum() {
        return gnum;
    }

    public void setGnum(BigDecimal gnum) {
        this.gnum = gnum;
    }

    public String getfCoincode() {
        return fCoincode;
    }

    public void setfCoincode(String fCoincode) {
        this.fCoincode = fCoincode == null ? null : fCoincode.trim();
    }

    public BigDecimal getFnum() {
        return fnum;
    }

    public void setFnum(BigDecimal fnum) {
        this.fnum = fnum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTradetime() {
        return tradetime;
    }

    public void setTradetime(Date tradetime) {
        this.tradetime = tradetime;
    }

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTradesign() {
        return tradesign;
    }

    public void setTradesign(String tradesign) {
        this.tradesign = tradesign == null ? null : tradesign.trim();
    }
}