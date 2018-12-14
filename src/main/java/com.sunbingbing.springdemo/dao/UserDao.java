package com.sunbingbing.springdemo.dao;

import com.sunbingbing.springdemo.model.User;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 描述：用户数据库操作对象
 * 创建人：bingbing.sun@outlook.com
 * 时间：2018/12/10 13:36
 */
@Repository
public class UserDao {

    //获取匹配的用户数量
    private final static String MATCH_COUNT_SQL = "SELECT count(*) FROM TB_USER WHERE USERNAME = ? AND PASSWORD = ?";

    //根据用户名获取用户
    private final static String GET_USER_BY_NAME_SQL = "SELECT * FROM TB_USER WHERE USERNAME = ?";

    //更新用户登录信息
    private final static String UPDATE_USER_INFO_SQL = "UPDATE TB_USER SET CREDITS = ?, LAST_IP = ?,LAST_DATE = ? WHERE USER_ID = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取数据库匹配的用户数量
     */
    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    /**
     * 根据用户名获取用户
     */
    public User getUserByName(String userName) {
        return jdbcTemplate.queryForObject(GET_USER_BY_NAME_SQL, new Object[]{userName}, User.class);
    }

    /**
     * 更新用户信息
     */
    public void updateUserInfo(User user) {
        jdbcTemplate.update(UPDATE_USER_INFO_SQL, user.getCredits(), user.getLastIp(), user.getLastVisit(), user.getUserId());
    }
}
