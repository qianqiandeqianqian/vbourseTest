package com.hucheng.common.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TdMarket extends AbstractObject{
    private Integer mkid;

    private String coincode;

    private String gCoincode;

    private Integer round;

    private String fCoincode;

    private Double feebuy;

    private Double feesell;

    private BigDecimal buymin;

    private BigDecimal buymax;

    private BigDecimal sellmin;

    private BigDecimal sellmax;

    private BigDecimal trademin;

    private BigDecimal trademax;

    private Integer onbuy;

    private Integer onsell;

    private Double invit1;

    private Double invit2;

    private Double invit3;

    private BigDecimal fxprice;

    private Double zhang;

    private Double die;

    private BigDecimal newprice;

    private BigDecimal buyprice;

    private BigDecimal sellprice;

    private BigDecimal minprice;

    private BigDecimal maxprice;

    private BigDecimal volume;

    private Double mchange;

    private Date daystime;

    private Date dayetime;

    private Integer status;

    public Integer getMkid() {
        return mkid;
    }

    public void setMkid(Integer mkid) {
        this.mkid = mkid;
    }

    public String getCoincode() {
        return coincode;
    }

    public void setCoincode(String coincode) {
        this.coincode = coincode == null ? null : coincode.trim();
    }

    public String getgCoincode() {
        return gCoincode;
    }

    public void setgCoincode(String gCoincode) {
        this.gCoincode = gCoincode == null ? null : gCoincode.trim();
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getfCoincode() {
        return fCoincode;
    }

    public void setfCoincode(String fCoincode) {
        this.fCoincode = fCoincode == null ? null : fCoincode.trim();
    }

    public Double getFeebuy() {
        return feebuy;
    }

    public void setFeebuy(Double feebuy) {
        this.feebuy = feebuy;
    }

    public Double getFeesell() {
        return feesell;
    }

    public void setFeesell(Double feesell) {
        this.feesell = feesell;
    }

    public BigDecimal getBuymin() {
        return buymin;
    }

    public void setBuymin(BigDecimal buymin) {
        this.buymin = buymin;
    }

    public BigDecimal getBuymax() {
        return buymax;
    }

    public void setBuymax(BigDecimal buymax) {
        this.buymax = buymax;
    }

    public BigDecimal getSellmin() {
        return sellmin;
    }

    public void setSellmin(BigDecimal sellmin) {
        this.sellmin = sellmin;
    }

    public BigDecimal getSellmax() {
        return sellmax;
    }

    public void setSellmax(BigDecimal sellmax) {
        this.sellmax = sellmax;
    }

    public BigDecimal getTrademin() {
        return trademin;
    }

    public void setTrademin(BigDecimal trademin) {
        this.trademin = trademin;
    }

    public BigDecimal getTrademax() {
        return trademax;
    }

    public void setTrademax(BigDecimal trademax) {
        this.trademax = trademax;
    }

    public Integer getOnbuy() {
        return onbuy;
    }

    public void setOnbuy(Integer onbuy) {
        this.onbuy = onbuy;
    }

    public Integer getOnsell() {
        return onsell;
    }

    public void setOnsell(Integer onsell) {
        this.onsell = onsell;
    }

    public Double getInvit1() {
        return invit1;
    }

    public void setInvit1(Double invit1) {
        this.invit1 = invit1;
    }

    public Double getInvit2() {
        return invit2;
    }

    public void setInvit2(Double invit2) {
        this.invit2 = invit2;
    }

    public Double getInvit3() {
        return invit3;
    }

    public void setInvit3(Double invit3) {
        this.invit3 = invit3;
    }

    public BigDecimal getFxprice() {
        return fxprice;
    }

    public void setFxprice(BigDecimal fxprice) {
        this.fxprice = fxprice;
    }

    public Double getZhang() {
        return zhang;
    }

    public void setZhang(Double zhang) {
        this.zhang = zhang;
    }

    public Double getDie() {
        return die;
    }

    public void setDie(Double die) {
        this.die = die;
    }

    public BigDecimal getNewprice() {
        return newprice;
    }

    public void setNewprice(BigDecimal newprice) {
        this.newprice = newprice;
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
        this.sellprice = sellprice;
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public BigDecimal getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(BigDecimal maxprice) {
        this.maxprice = maxprice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Double getMchange() {
        return mchange;
    }

    public void setMchange(Double mchange) {
        this.mchange = mchange;
    }

    public Date getDaystime() {
        return daystime;
    }

    public void setDaystime(Date daystime) {
        this.daystime = daystime;
    }

    public Date getDayetime() {
        return dayetime;
    }

    public void setDayetime(Date dayetime) {
        this.dayetime = dayetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}