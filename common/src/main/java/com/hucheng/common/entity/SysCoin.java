package com.hucheng.common.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SysCoin extends AbstractObject{
    private String coincode;

    private Integer cid;

    private String usname;

    private String enname;

    private String img;

    private String sort;

    private Date ontime;

    private Date offtime;

    private Integer status;

    private String mainaddr;

    private Integer isvirtual;

    private String wallettype;

    private Integer zrstatus;

    private Integer zrtype;

    private BigDecimal zrfeeratio;

    private Integer zrfeenum;

    private Integer zcstatus;

    private Integer zctype;

    private BigDecimal zcfeeratio;

    private Integer zcfeenum;

    private String introduction;

    private String remark;

    public String getCoincode() {
        return coincode;
    }

    public void setCoincode(String coincode) {
        this.coincode = coincode == null ? null : coincode.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname == null ? null : usname.trim();
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Date getOntime() {
        return ontime;
    }

    public void setOntime(Date ontime) {
        this.ontime = ontime;
    }

    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMainaddr() {
        return mainaddr;
    }

    public void setMainaddr(String mainaddr) {
        this.mainaddr = mainaddr == null ? null : mainaddr.trim();
    }

    public Integer getIsvirtual() {
        return isvirtual;
    }

    public void setIsvirtual(Integer isvirtual) {
        this.isvirtual = isvirtual;
    }

    public String getWallettype() {
        return wallettype;
    }

    public void setWallettype(String wallettype) {
        this.wallettype = wallettype == null ? null : wallettype.trim();
    }

    public Integer getZrstatus() {
        return zrstatus;
    }

    public void setZrstatus(Integer zrstatus) {
        this.zrstatus = zrstatus;
    }

    public Integer getZrtype() {
        return zrtype;
    }

    public void setZrtype(Integer zrtype) {
        this.zrtype = zrtype;
    }

    public BigDecimal getZrfeeratio() {
        return zrfeeratio;
    }

    public void setZrfeeratio(BigDecimal zrfeeratio) {
        this.zrfeeratio = zrfeeratio;
    }

    public Integer getZrfeenum() {
        return zrfeenum;
    }

    public void setZrfeenum(Integer zrfeenum) {
        this.zrfeenum = zrfeenum;
    }

    public Integer getZcstatus() {
        return zcstatus;
    }

    public void setZcstatus(Integer zcstatus) {
        this.zcstatus = zcstatus;
    }

    public Integer getZctype() {
        return zctype;
    }

    public void setZctype(Integer zctype) {
        this.zctype = zctype;
    }

    public BigDecimal getZcfeeratio() {
        return zcfeeratio;
    }

    public void setZcfeeratio(BigDecimal zcfeeratio) {
        this.zcfeeratio = zcfeeratio;
    }

    public Integer getZcfeenum() {
        return zcfeenum;
    }

    public void setZcfeenum(Integer zcfeenum) {
        this.zcfeenum = zcfeenum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}