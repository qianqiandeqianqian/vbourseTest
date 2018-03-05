package com.hucheng.rmi.coin;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有币的类型，包括以太坊币、比特币等等。。。
 * @author xuchunlin
 * @version V1.0
 * @Title: EnumCoin
 * @Package com.hucheng.rmi.coin
 * @Description: TODO
 * @date 2017/12/27 12:14
 */
public enum  EnumCoin {
    wkb,fct,rnt,usdt,dgc,
    eth,llt,bat,rdn,knc,kin,snt,wc,sdc,dcn;

    public static boolean is(String name){
        List<String> list=new ArrayList<String>();
       EnumCoin[] values= EnumCoin.values();
       for (EnumCoin enumCoin: values){
           list.add(enumCoin.name());
       }
       return list.contains(name);
    }
}
