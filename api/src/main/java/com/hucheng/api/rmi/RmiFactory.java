package com.hucheng.api.rmi;

import com.hucheng.rmi.service.RmiWalletInterface;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: RmiFactory
 * @Package com.hucheng.rmi.client
 * @Description: TODO
 * @date 2017/12/27 11:59
 */
public class RmiFactory extends RmiProxyFactoryBean implements ApplicationContextAware {

    private static ApplicationContext context;//声明一个静态变量保存

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }

    public static RmiWalletInterface rmiWalletInterface(){
       return context.getBean("rmiFactory",RmiWalletInterface.class);
    }
}