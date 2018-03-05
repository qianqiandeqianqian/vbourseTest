package com.hucheng.chinawkb.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: HomeController
 * @Package com.hucheng.chinawkb.controller.home
 * @Description: TODO
 * @date 2017/11/29 14:40
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("home/index");
    }
}
