package com.hucheng.api.controller.app;

import com.hucheng.api.auth.Jwt;
import com.hucheng.api.controller.BaseController;
import com.hucheng.common.codec.HttpResponse;
import com.hucheng.common.entity.SysUser;
import com.hucheng.common.entity.SysUserLogin;
import com.hucheng.common.global.Constant;
import com.hucheng.common.view.VLoginRes;
import com.hucheng.service.SysUserService;
import com.hucheng.util.MD5Utils;
import com.hucheng.util.StringUtils;
import com.hucheng.util.UUID;
import com.hucheng.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * @author xuchunlin
 * @version V1.0
 * @Title: LoginController
 * @Package com.hucheng.api.controller.app
 * @Description: 客户端登录接口
 * @date 2017/11/30 16:08
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;
    /**
     * 客户端用户名和密码登录获取token
     * @param username 用户名
     * @param password 密码
     * @param <T>
     * @return  返回用户信息及token
     */
    @RequestMapping(value = "/loginToken", method = {RequestMethod.POST , RequestMethod.GET })
    @ResponseBody
    public <T> HttpResponse<T> loginToken(@RequestParam(value = "username",required = true) String username,
                                          @RequestParam(value = "password",required = true) String password )throws Exception{
        HttpResponse<VLoginRes> httpResponse=new HttpResponse();
        if(StringUtils.isNullOrEmpty(username)){
            return new HttpResponse<>().check("用户名不能为空!");
        }
        if(StringUtils.isNullOrEmpty(password)){
            return new HttpResponse<>().check("密码不能为空!");
        }
        SysUser loginUser=null;
        String loginType="";
        try {
            username = username.trim().toLowerCase();
            password = MD5Utils.pswd(password);
            if (Utils.isMobile(username)) {
                loginType="手机登录";
                //手机号登录
                loginUser = sysUserService.findUserByMobileAndPswd(username, password);
            } else if (Utils.isEmail(username)) {
                loginType="邮箱登录";
                //邮箱地址登录
                loginUser = sysUserService.findUserByEmailAndPswd(username, password);
            } else {
                loginType="用户名登录";
                //用户名登录
                loginUser = sysUserService.findUserByUsernameAndPswd(username, password);
            }
            if(loginUser!=null){
                VLoginRes loginRes=new VLoginRes();
                loginRes.setUserid(loginUser.getUserid());
                loginRes.setUsername(loginUser.getUsername());
                loginRes.setEmail(loginUser.getEmail());
                loginRes.setMobile(loginUser.getMobile());
                loginRes.setCsrf(UUID.randomUUID());
                String accessToken=Jwt.sign(loginRes,Constant.TOKEN_TIMEOUT_LONG);
                loginRes.setToken(accessToken);
                loginRes.setExp(Constant.TOKEN_TIMEOUT_LONG);

                SysUserLogin userLogin=new SysUserLogin();
                userLogin.setEmail(loginUser.getEmail());
                userLogin.setIp(client_ip());
                userLogin.setLogintime(new Date());
                userLogin.setLogintype(loginType);
                userLogin.setShowname(loginUser.getShowname());
                userLogin.setSource(client_osType());
                userLogin.setUstatus(loginUser.getStatus());
                userLogin.setUseragent(client_userAgent());
                userLogin.setUserid(loginUser.getUserid());
                userLogin.setUsername(loginUser.getUsername());
                return httpResponse.success("登录成功",loginRes);
            }else{
                return httpResponse.check("用户名或密码错误!");
            }
        }catch (Exception e){
            return httpResponse.failed("请求失败%s",e.getMessage());
        }
    }
}
