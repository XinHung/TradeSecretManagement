package com.hung.tsm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hung.tsm.model.User;
import com.hung.tsm.utils.MD5;

@Repository
public class UserDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public User getUserByEmpIdAndPwd(String empId, String empPwd) throws DataAccessException {
		String sql = "select * from user where EMP_ID= ? and EMP_PWD= ?";
		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), empId, MD5.getMd5String(empPwd));
		if(user == null) {
			return user;
		} else {
			return user;
		}
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
