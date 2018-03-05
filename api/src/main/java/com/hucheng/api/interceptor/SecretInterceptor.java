package com.hucheng.api.interceptor;

import com.hucheng.api.auth.Jwt;
import com.hucheng.common.codec.HttpResponse;
import com.hucheng.common.exception.TokenTimeoutException;
import com.hucheng.common.global.Constant;
import com.hucheng.common.view.VLoginRes;
import com.hucheng.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * Created by 许春林 on 2017/1/9.
 */
public class SecretInterceptor extends HandlerInterceptorAdapter {

    public final static Logger logger= LoggerFactory.getLogger(SecretInterceptor.class);

    private String[] allowUrls;

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        PrintWriter out=null;
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        if("/".equals(requestUrl)){
            return true;
        }
        if(null != allowUrls && allowUrls.length>=1) {
            for(String url : allowUrls) {
                if(!"/".equals(url) && requestUrl.contains(url)) {
                    return true;
                }
            }
        }
        String access_token=request.getHeader(Constant.ACCESS_TOKEN);
        if(access_token==null || "".equals(access_token)) {
            access_token=request.getParameter(Constant.ACCESS_TOKEN);
        }
        logger.debug("access_token:{}", access_token);
        if(access_token!=null && !"".equals(access_token)){
            try {
                VLoginRes loginRes = Jwt.unsign(access_token, VLoginRes.class);
                if (loginRes != null) {
                    request.setAttribute(Constant.REQ_LOGIN_USER, loginRes);
                    return true;
                }
            }catch (TokenTimeoutException e){
                //token超时
                response.setContentType("application/json; charset=utf-8");
                out = response.getWriter();
                HttpResponse<String> res = new HttpResponse<String>();
                out.print(JSONUtils.obj2json(res.tokenTimeout("access_token timeout!")));
                out.close();
                return false;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        out=response.getWriter();
        HttpResponse<String> res=new HttpResponse<String>();
        out.print(JSONUtils.obj2json(res.check("access_token is null!")));
        out.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }


}
