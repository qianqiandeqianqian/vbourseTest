package com.hucheng.api.interceptor;

import com.hucheng.common.enums.EnumOsType;
import com.hucheng.common.global.Constant;
import com.hucheng.util.HttpRequestUtil;
import com.hucheng.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.getSession().setAttribute(Constant.SYSTEM_VERSION, sysversion);//本系统版本号存储
        logger.debug("CONTENT-TYPE:"+request.getContentType());

        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        logger.debug(" {} {}",request.getMethod() ,requestUrl);
        String userAgent=request.getParameter("User-Agent");
        String userLang=request.getParameter("User-Lang");//获取自定义语言
        if(StringUtils.isNullOrEmpty(userAgent)){
            userAgent=request.getHeader("user_agent");
        }
        if(StringUtils.isNullOrEmpty(userAgent)){
            userAgent=request.getHeader("User-Agent");
        }
        if(StringUtils.isNullOrEmpty(userLang)){
            userLang=request.getHeader("User-Lang");
        }
        if(StringUtils.isNullOrEmpty(userLang)){//获取客户端默认语言
            userLang=request.getHeader("Accept-Language");
        }
        if(StringUtils.isNullOrEmpty(userLang)){//获取客户端默认语言
            userLang="zn-cn";
        }
        request.setAttribute(Constant.REQ_UA,userAgent);
        request.setAttribute(Constant.REQ_LANG,userLang);
        request.setAttribute(Constant.REQ_IP, HttpRequestUtil.getIpAddress(request));
        if(StringUtils.isNullOrEmpty(userAgent)){
            userAgent="";
        }
        if(userAgent.toLowerCase().contains("android") || userAgent.toLowerCase().contains("mobile")){
            request.setAttribute(Constant.REQ_OSTYPE, EnumOsType.android.name());
        }else if(userAgent.toLowerCase().contains("ios") || userAgent.toLowerCase().contains("ipad")){
            request.setAttribute(Constant.REQ_OSTYPE,EnumOsType.ios.name());
        }else{
            request.setAttribute(Constant.REQ_OSTYPE,EnumOsType.pc.name());
        }

        if("/".equals(requestUrl)){
            return true;
        }
        if(!StringUtils.isNullOrEmpty(userAgent)){
            Pattern pattern_android=Pattern.compile("vbourse/(v|\\.|\\d){1,7}",Pattern.CASE_INSENSITIVE);
            Pattern pattern_ios=Pattern.compile("vbourse(\\sBeta)?/(v|\\.|\\d){1,7}",Pattern.CASE_INSENSITIVE);
            Matcher matcher=pattern_android.matcher(userAgent);
            Matcher matcher1=pattern_ios.matcher(userAgent);
            String version="";
            if(matcher.find()) {
                version=matcher.group();
            }else if(matcher1.find()){
                version=matcher1.group();
            }
            if(!StringUtils.isNullOrEmpty(version)){
                version=version.replace("vbourse/", "").replaceAll("vbourse(\\sBeta)?/","");
                request.setAttribute(Constant.REQ_APPVERSION,version);
                logger.debug("userAgent:{} ,version:{}",userAgent,version);
                return true;
            }
        }
        logger.error("非法客户端访问！userAgent:{}",userAgent);
        response.getWriter().write("非法请求!");
        return false;
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
