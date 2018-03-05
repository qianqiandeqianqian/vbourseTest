package com.hucheng.chinawkb.interceptor;

import com.alibaba.fastjson.JSON;
import com.hucheng.common.bean.AdminUser;
import com.hucheng.common.codec.HttpCoder;
import com.hucheng.common.codec.HttpResponse;
import com.hucheng.common.exception.SessionAdminTimeoutException;
import com.hucheng.common.global.Constant;
import com.hucheng.util.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: HttpInterceptor
 * @Package com.hucheng.chinawkb.interceptor
 * @Description: 系统后台登录拦截
 * @date 2017/11/28 19:27
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    public final static Logger logger= LoggerFactory.getLogger(AdminInterceptor.class);

    public String[] allowUrls;//允许访问不进行拦截的路径配置


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        if(null != allowUrls && allowUrls.length>=1) {
            for(String url : allowUrls) {
                if(requestUrl.contains(url)) {
                    return true;
                }
            }
        }
        AdminUser user = (AdminUser) request.getSession().getAttribute(Constant.SESSION_ADMIN);
        if(user != null) {
            return true;  //返回true，则这个方面调用后会接着调用postHandle(),  afterCompletion()
        }else{
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){

                response.setContentType("application/json, charset=UTF-8");
                PrintWriter out=response.getWriter();
                try{
                    out.print(new HttpResponse<>().adminTimeout("timeout"));
                    return false;
                }catch(Exception e){
                    throw new SessionAdminTimeoutException();//返回到配置文件中定义的路径
                }finally {
                    try{
                        out.close();
                    }catch (Exception e){}
                }
            }
            // 未登录  跳转到登录页面
            throw new SessionAdminTimeoutException();//返回到配置文件中定义的路径
        }
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

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }
}
