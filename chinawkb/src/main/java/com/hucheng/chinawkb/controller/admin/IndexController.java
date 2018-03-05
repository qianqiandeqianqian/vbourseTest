package com.hucheng.chinawkb.controller.admin;

import com.google.code.kaptcha.Constants;
import com.hucheng.chinawkb.controller.BaseController;
import com.hucheng.common.bean.AdminUser;
import com.hucheng.common.codec.HttpResponse;
import com.hucheng.common.entity.DandanAdmin;
import com.hucheng.common.global.Constant;
import com.hucheng.service.DandanAdminService;
import com.hucheng.util.MD5Utils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: IndexController
 * @Package com.hucheng.chinawkb.controller.admin
 * @Description: TODO
 * @date 2017/11/28 16:44
 */
@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {

    public final static Logger logger=getLogger(IndexController.class);

    @Autowired
    private DandanAdminService dandanAdminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("admin/index");
    }

    /**
     * 后台登录页面跳转
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        AdminUser user=session_user();
        if(user!=null){
            return new ModelAndView("redirect:/admin/security_main");
        }
        return new ModelAndView("admin/login");
    }

    @RequestMapping(value="/loginOut",method= {RequestMethod.GET})
    public ModelAndView loginOut() throws Exception{
        request.getSession().removeAttribute(Constant.SESSION_ADMIN);
        logger.debug("来自IP:{}退出...",request_ip());
        return new ModelAndView("redirect:/admin/login");
    }

    /**
     * 后台安全登录验证
     * @param username
     * @param password
     * @param rqcode
     * @return
     */
    @RequestMapping(value = "/security_login", method = RequestMethod.POST)
    @ResponseBody
    public <T> HttpResponse<T> security_login(@RequestParam(value = "username" , required = true) String username,
                                       @RequestParam(value = "password" , required = true) String password,
                                       @RequestParam(value = "rqcode" , required = true) String rqcode) throws Exception{
        HttpResponse httpResponse=new HttpResponse();
        String kaptchaExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        logger.debug("kaptchaExpected:{}", kaptchaExpected);
        if (rqcode == null || !rqcode.equalsIgnoreCase(kaptchaExpected)) {
            return httpResponse.check("验证码错误", null);
        }
        DandanAdmin _admin=dandanAdminService.findByUsername(username);
        if(_admin==null){
            return httpResponse.check("用户名不存在",null);
        }
        logger.debug("用户名：{},密码：{}",username,password);
        String $pswd= MD5Utils.MD5(password);
        DandanAdmin admin=dandanAdminService.findByUsernameAndPswd(username,$pswd);
        if(admin!=null){
            admin.setPassword(null);
            request.getSession().setAttribute(Constant.SESSION_ADMIN, admin);
            return httpResponse.success("登录成功",null);
        }else{
            return httpResponse.check("密码错误",null);
        }

    }

    /**
     * 后台管理主界面
     * @return
     */
    @RequestMapping(value = "/security_main", method = RequestMethod.GET)
    public ModelAndView security_main(){
        return new ModelAndView("admin/main");
    }

}
