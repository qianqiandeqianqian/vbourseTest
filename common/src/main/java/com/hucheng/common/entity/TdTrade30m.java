package com.hucheng.common.entity;

public class TdTrade30m extends AbstractObject{
    private Integer id;

    private String coinname;

    private String dCoinname;

    private String date;

    private String type;

    private Long time;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoinname() {
        return coinname;
    }

    public void setCoinname(String coinname) {
        this.coinname = coinname == null ? null : coinname.trim();
    }

    public String getdCoinname() {
        return dCoinname;
    }

    public void setdCoinname(String dCoinname) {
        this.dCoinname = dCoinname == null ? null : dCoinname.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}