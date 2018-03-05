package com.hucheng.api.controller.wallet;

import com.alibaba.fastjson.JSON;
import com.hucheng.api.rmi.RmiFactory;
import com.hucheng.common.codec.HttpResponse;
import com.hucheng.rmi.codec.*;
import com.hucheng.rmi.coin.EnumCoin;
import com.hucheng.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: WalletController
 * @Package com.hucheng.api.controller.wallet
 * @Description: TODO
 * @date 2017/12/29 9:26
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private RmiFactory rmiFactory;

    /**
     * 钱包转账
     * @param coinName
     * @param address
     * @param value
     * @return
     */
    @RequestMapping(value = "/transferAddressAmount", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResponse<AbsTransactionResult> transferAddressAmount(
                                    @RequestParam(value = "coinName", required = true) String coinName,
                                    @RequestParam(value = "address", required = true) String address,
                                    @RequestParam(value = "value", required = true) BigDecimal value){
        HttpResponse<TransactionResult> httpResponse=new HttpResponse();
        boolean flag=EnumCoin.is(coinName);
        if(flag) {
            BigInteger wei_value=Convert.toWei(value, Convert.Unit.ETHER).toBigInteger();
            System.out.println("转入eth:"+value+"  转换成wei:"+wei_value);
            //判断金额是否足够
            RMIResponse rootResponse = RmiFactory.rmiWalletInterface().getBalance(EnumCoin.valueOf(coinName));
            if(rootResponse.getCode()==RMIResponse.EnumsRmiCode.SUCCESS.getCode()){
               BalanceResult balanceResult=(BalanceResult) rootResponse.getBody();
               if(balanceResult.getValue().compareTo(wei_value)<0){
                   return httpResponse.check("当前账户余额不足");
               }else{
                   //交易
                   RMIResponse rmiResponse = RmiFactory.rmiWalletInterface().transfer
                           (EnumCoin.valueOf(coinName), address,wei_value,BigInteger.valueOf(0));
                   System.out.println("交易是否成功：" + JSON.toJSONString(rmiResponse));
                   if(rmiResponse.getCode()== RMIResponse.EnumsRmiCode.SUCCESS.getCode()) {
                       TransactionResult result=(TransactionResult)rmiResponse.getBody();
                       return httpResponse.success(result);
                   }else if(rmiResponse.getCode()==RMIResponse.EnumsRmiCode.VALIDATE.getCode()){
                       return httpResponse.check(rmiResponse.getMessage());
                   }
                   return httpResponse.failed(rmiResponse.getMessage());
               }
            }else if(rootResponse.getCode()==RMIResponse.EnumsRmiCode.VALIDATE.getCode()){
                return httpResponse.check(rootResponse.getMessage());
            }
            return httpResponse.failed(rootResponse.getMessage());
        }
        return httpResponse.failed("不存在的钱包名称"+coinName);
    }

    /**
     * 获取钱包余额
     * @param coinName
     * @param address
     * @return
     */
    @RequestMapping(value = "/getBalanceOf", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResponse<AbsTransactionResult> getBalanceOf(
            @RequestParam(value = "coinName", required = true) String coinName,
            @RequestParam(value = "address", required = true) String address){
        HttpResponse<BalanceResult> httpResponse=new HttpResponse();
        boolean flag=EnumCoin.is(coinName);
        if(flag) {
            RMIResponse rmiResponse = RmiFactory.rmiWalletInterface().getBalance(EnumCoin.valueOf(coinName), address);
            if(rmiResponse.getCode()==RMIResponse.EnumsRmiCode.SUCCESS.getCode()){
                BalanceResult balanceResult= (BalanceResult)rmiResponse.getBody();
                return httpResponse.success(balanceResult);
            }else if(rmiResponse.getCode()==RMIResponse.EnumsRmiCode.VALIDATE.getCode()){
                return httpResponse.check(rmiResponse.getMessage());
            }
            return httpResponse.failed(rmiResponse.getMessage());
        }
        return httpResponse.check("不存在的钱包名称"+coinName);
    }

    /**
     * 创建钱包
     * @param userId 设置密码
     * @return
     */
    @RequestMapping(value = "/createAccount", method = {RequestMethod.POST, RequestMethod.GET}, consumes = {"multipart/form-data","application/x-www-form-urlencoded"})
    @ResponseBody
    public HttpResponse<AbsTransactionResult> createAccount(@RequestParam(value = "userId", required = true) Integer userId){
        HttpResponse<AccountResult> httpResponse=new HttpResponse();
        try {
            if(!StringUtils.isNullOrEmpty(userId)) {
                RMIResponse rmiResponse = RmiFactory.rmiWalletInterface().createAccount(userId);
                if(rmiResponse.getCode()==RMIResponse.EnumsRmiCode.SUCCESS.getCode()){
                    AccountResult accountResult= (AccountResult)rmiResponse.getBody();
                    return httpResponse.success(accountResult);
                }else if(rmiResponse.getCode()==RMIResponse.EnumsRmiCode.VALIDATE.getCode()){
                    return httpResponse.check(rmiResponse.getMessage());
                }
                return httpResponse.failed(rmiResponse.getMessage());
            }
            return httpResponse.check("密码不能为空");
        }catch (Exception e){
            e.printStackTrace();
            return httpResponse.failed(e.getMessage());
        }
    }

    /**
     * 使用from地址给to地址转账
     * @param coinName 合约名称
     * @param from 转账地址
     * @param to 收账地址
     * @param value 转账金额
     * @return
     */
    @RequestMapping(value = "/transferFrom", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResponse<AbsTransactionResult> transferFrom(
                                                   @RequestParam(value = "coinName", required = true) String coinName,
                                                   @RequestParam(value = "from", required = true) String from,
                                                   @RequestParam(value = "to", required = true) String to,
                                                   @RequestParam(value = "value", required = true) BigDecimal value,
                                                   @RequestParam(value = "gasPrice", required = true) BigInteger gasPrice){
        HttpResponse<TransactionResult> httpResponse=new HttpResponse();
        boolean flag=EnumCoin.is(coinName);
        if(flag) {
            BigInteger wei_value=Convert.toWei(value, Convert.Unit.ETHER).toBigInteger();
            System.out.println("转入eth:"+value+"  转换成wei:"+wei_value);
            //判断金额是否足够
            RMIResponse rootResponse = RmiFactory.rmiWalletInterface().getBalance(EnumCoin.valueOf(coinName));
            if(rootResponse.getCode()==RMIResponse.EnumsRmiCode.SUCCESS.getCode()){
                BalanceResult balanceResult=(BalanceResult) rootResponse.getBody();
                if(balanceResult.getValue().intValue()<wei_value.intValue()){
                    return httpResponse.check("当前账户余额不足");
                }else{
                    //交易
                    RMIResponse rmiResponse = RmiFactory.rmiWalletInterface().transferFrom
                            (EnumCoin.valueOf(coinName), from, to ,wei_value,BigInteger.valueOf(0));
                    System.out.println("交易是否成功：" + JSON.toJSONString(rmiResponse));
                    if(rmiResponse.getCode()== RMIResponse.EnumsRmiCode.SUCCESS.getCode()) {
                        TransactionResult result=(TransactionResult)rmiResponse.getBody();
                        return httpResponse.success(result);
                    }else if(rmiResponse.getCode()==RMIResponse.EnumsRmiCode.VALIDATE.getCode()){
                        return httpResponse.check(rmiResponse.getMessage());
                    }
                    return httpResponse.failed(rmiResponse.getMessage());
                }
            }else if(rootResponse.getCode()==RMIResponse.EnumsRmiCode.VALIDATE.getCode()){
                return httpResponse.check(rootResponse.getMessage());
            }
            return httpResponse.failed(rootResponse.getMessage());
        }
        return httpResponse.failed("不存在的钱包名称"+coinName);
    }
}
