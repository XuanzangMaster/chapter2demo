package com.sunbingbing.springdemo.controller;

import com.sunbingbing.springdemo.model.LoginCommand;
import com.sunbingbing.springdemo.model.User;
import com.sunbingbing.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 描述：用户登录控制器
 * 创建人：bingbing.sun@outlook.com
 * 时间：2018/12/10 17:16
 */
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login.do")
    public ModelAndView checkLogin(HttpServletRequest httpServletRequest, LoginCommand loginCommand) {
        boolean isUserMathed = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (isUserMathed) {
            return new ModelAndView("login","error","用户名或者密码错误");
        } else {
            User user = userService.getUser(loginCommand.getUserName());
            user.setLastIp(httpServletRequest.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            httpServletRequest.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }
}
