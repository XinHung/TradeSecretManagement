package com.hung.tsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hung.tsm.model.SecurityLevel;

@Repository
public class SecurityLevelDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<SecurityLevel> getAllSecurity() throws DataAccessException {
		String sql = "select * from security_level order by level asc";
		List<SecurityLevel> securityList = jdbcTemplate.query(sql, new SecurityLevelRowMapper());
		if(securityList == null) {
			return null;
		} else {
			return securityList;
		}
	}
	
	/**
     * 內部類別，把結果集轉為 SecurityLevel 物件
     */
    private class SecurityLevelRowMapper implements RowMapper<SecurityLevel> {
        @Override
        public SecurityLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
        	SecurityLevel security  = new SecurityLevel();
        	security.setId(rs.getInt("ID"));
        	security.setLevel(rs.getString("LEVEL"));
        	security.setCreateEmpId(rs.getString("CREATE_EMP_ID"));
        	security.setCreateEmpName(rs.getString("CREATE_EMP_NAME"));
        	security.setCreateTime(rs.getDate("CREATE_TIME"));
        	security.setLastEditEmpId(rs.getString("LAST_EDIT_EMP_ID"));
        	security.setLastEditEmpName(rs.getString("LAST_EDIT_EMP_NAME"));
        	security.setLastEditTime(rs.getDate("LAST_EDIT_TIME"));
            return security;
        }
    }
}
