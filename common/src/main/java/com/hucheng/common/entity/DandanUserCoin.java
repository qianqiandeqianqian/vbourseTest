package com.hucheng.common.entity;

import java.math.BigDecimal;

public class DandanUserCoin extends AbstractObject{
    private Integer id;

    private Integer userid;

    private BigDecimal cny;

    private BigDecimal cnyd;

    private BigDecimal btc;

    private BigDecimal btcd;

    private String btcb;

    private BigDecimal ltc;

    private BigDecimal ltcd;

    private String ltcb;

    private BigDecimal eth;

    private BigDecimal ethd;

    private String ethb;

    private BigDecimal wkb;

    private BigDecimal wkbd;

    private String wkbb;

    private BigDecimal llt;

    private BigDecimal lltd;

    private String lltb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public BigDecimal getCny() {
        return cny;
    }

    public void setCny(BigDecimal cny) {
        this.cny = cny;
    }

    public BigDecimal getCnyd() {
        return cnyd;
    }

    public void setCnyd(BigDecimal cnyd) {
        this.cnyd = cnyd;
    }

    public BigDecimal getBtc() {
        return btc;
    }

    public void setBtc(BigDecimal btc) {
        this.btc = btc;
    }

    public BigDecimal getBtcd() {
        return btcd;
    }

    public void setBtcd(BigDecimal btcd) {
        this.btcd = btcd;
    }

    public String getBtcb() {
        return btcb;
    }

    public void setBtcb(String btcb) {
        this.btcb = btcb == null ? null : btcb.trim();
    }

    public BigDecimal getLtc() {
        return ltc;
    }

    public void setLtc(BigDecimal ltc) {
        this.ltc = ltc;
    }

    public BigDecimal getLtcd() {
        return ltcd;
    }

    public void setLtcd(BigDecimal ltcd) {
        this.ltcd = ltcd;
    }

    public String getLtcb() {
        return ltcb;
    }

    public void setLtcb(String ltcb) {
        this.ltcb = ltcb == null ? null : ltcb.trim();
    }

    public BigDecimal getEth() {
        return eth;
    }

    public void setEth(BigDecimal eth) {
        this.eth = eth;
    }

    public BigDecimal getEthd() {
        return ethd;
    }

    public void setEthd(BigDecimal ethd) {
        this.ethd = ethd;
    }

    public String getEthb() {
        return ethb;
    }

    public void setEthb(String ethb) {
        this.ethb = ethb == null ? null : ethb.trim();
    }

    public BigDecimal getWkb() {
        return wkb;
    }

    public void setWkb(BigDecimal wkb) {
        this.wkb = wkb;
    }

    public BigDecimal getWkbd() {
        return wkbd;
    }

    public void setWkbd(BigDecimal wkbd) {
        this.wkbd = wkbd;
    }

    public String getWkbb() {
        return wkbb;
    }

    public void setWkbb(String wkbb) {
        this.wkbb = wkbb == null ? null : wkbb.trim();
    }

    public BigDecimal getLlt() {
        return llt;
    }

    public void setLlt(BigDecimal llt) {
        this.llt = llt;
    }

    public BigDecimal getLltd() {
        return lltd;
    }

    public void setLltd(BigDecimal lltd) {
        this.lltd = lltd;
    }

    public String getLltb() {
        return lltb;
    }

    public void setLltb(String lltb) {
        this.lltb = lltb == null ? null : lltb.trim();
    }
}