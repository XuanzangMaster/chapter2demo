package com.sunbingbing.springdemo.dao;

import com.sunbingbing.springdemo.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 描述：登录日志操作对象
 * 创建人：bingbing.sun@outlook.com
 * 时间：2018/12/10 16:16
 */
@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;

    //插入登录日志
    private final static String INSERT_LOGIN_LOG = "INSERT INTO TB_LOGIN_LOG(LOGIN_LOG_ID, USER_ID, LOGIN_IP, LOGIN_DATE) VALUES(?,?,?,?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 插入登录日志
     */
    public void insertLoginLog(LoginLog loginLog) {
        jdbcTemplate.update(INSERT_LOGIN_LOG, loginLog.getUserId(), loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate());
    }




}
