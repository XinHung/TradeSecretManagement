package com.hung.tsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hung.tsm.model.ProductLevel;

@Repository
public class ProductLevelDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<ProductLevel> getAllProductLevel() throws DataAccessException {
		String sql = "select * from product_level order by id asc";
		List<ProductLevel> productLevelList = jdbcTemplate.query(sql, new ProductLevelRowMapper());
		if(productLevelList == null) {
			return null;
		} else {
			return productLevelList;
		}
	}
	
	/**
     * 內部類別，把結果集轉為 ProductLevel 物件
     */
    private class ProductLevelRowMapper implements RowMapper<ProductLevel> {
        @Override
        public ProductLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ProductLevel productLevel = new ProductLevel();
        	productLevel.setId(rs.getInt("ID"));
        	productLevel.setName(rs.getString("NAME"));
        	productLevel.setCreateEmpId(rs.getString("CREATE_EMP_ID"));
        	productLevel.setCreateEmpName(rs.getString("CREATE_EMP_NAME"));
        	productLevel.setCreateTime(rs.getDate("CREATE_TIME"));
        	productLevel.setLastEditEmpId(rs.getString("LAST_EDIT_EMP_ID"));
        	productLevel.setLastEditEmpName(rs.getString("LAST_EDIT_EMP_NAME"));
        	productLevel.setLastEditTime(rs.getDate("LAST_EDIT_TIME"));
            return productLevel;
        }
    }
}
