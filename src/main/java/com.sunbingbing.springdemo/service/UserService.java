package com.sunbingbing.springdemo.service;

import com.sunbingbing.springdemo.dao.LoginLogDao;
import com.sunbingbing.springdemo.dao.UserDao;
import com.sunbingbing.springdemo.model.LoginLog;
import com.sunbingbing.springdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 描述：用户登录业务
 * 创建人：bingbing.sun@outlook.com
 * 时间：2018/12/10 15:36
 */
@Service
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;
    private Random random = new Random();

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password) {
        return userDao.getMatchCount(userName, password) > 0;
    }

    public User getUser(String userName) {
        return userDao.getUserByName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(10 + user.getCredits());
        userDao.updateUserInfo(user);
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginLogId(random.nextInt(100000000));
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
    }

}
