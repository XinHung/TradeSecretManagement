package com.hung.tsm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hung.tsm.model.User;
import com.hung.tsm.utils.MD5;

@SpringBootTest
public class LoginControllerTest {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Test
	void doLoginTest() {
		String empId  = "22193";
		String empPwd = "123456789";
		String sql = "select * from user where EMP_ID= ? and EMP_PWD = ?";
		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), empId, MD5.getMd5String(empPwd));
		assertEquals(user.getEmpName(), "陳信宏");
	}
	
	/**
     * 內部類別，把結果集轉為 User 物件
     */
    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        	User user  = new User();
            user.setId(rs.getInt("ID"));
            user.setEmpId(rs.getString("EMP_ID"));
            user.setEmpName(rs.getString("EMP_NAME"));
            user.setPassword(rs.getString("EMP_PWD"));
            user.setDepartment(rs.getString("DEPARTMENT"));
            user.setSex(rs.getBoolean("SEX"));
            user.setIsAdmin(rs.getBoolean("IS_ADMIN"));
            user.setIsUserAdmin(rs.getBoolean("IS_USER_ADMIN"));
            user.setEmail(rs.getString("EMAIL"));
            user.setRegDate(rs.getDate("REG_DATE"));
            user.setLastLoginDate(rs.getDate("LAST_LOGIN_TIME"));
            user.setRegisterIp(rs.getString("REG_IP"));
            user.setLastLoginIp(rs.getString("LAST_LOGIN_IP"));
            return user;
        }
    }
}
