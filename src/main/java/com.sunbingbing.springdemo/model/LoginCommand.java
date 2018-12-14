package com.sunbingbing.springdemo.model;

/**
 * 描述：登录用户数据请求信息
 * 创建人：bingbing.sun@outlook.com
 * 时间：2018/12/10 17:14
 */
public class LoginCommand {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
