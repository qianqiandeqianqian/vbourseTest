package com.hucheng.chinawkb.interceptor;

import com.hucheng.common.global.Constant;
import com.hucheng.util.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: HttpInterceptor
 * @Package com.hucheng.chinawkb.interceptor
 * @Description: 处理所有请求，获取请求信息，不做拦截
 * @date 2017/11/28 19:27
 */
public class HttpInterceptor  extends HandlerInterceptorAdapter {

    public final static Logger logger= LoggerFactory.getLogger(HttpInterceptor.class);

    private String sysversion=Constant.DEF_SYS_VER;//系统默认版本

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(Constant.REQ_UA,request.getHeader("User-Agent"));
        request.setAttribute(Constant.REQ_IP, HttpRequestUtil.getIpAddress(request));
        request.getSession().setAttribute(Constant.SYSTEM_VERSION, sysversion);//本系统版本号存储
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    public void setSysversion(String sysversion) {
        this.sysversion = sysversion;
    }
}
