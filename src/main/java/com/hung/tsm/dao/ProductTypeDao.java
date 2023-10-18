package com.hung.tsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hung.tsm.model.ProductType;

@Repository
public class ProductTypeDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<ProductType> getAllProductType() throws DataAccessException {
		String sql = "select * from product_type order by id asc";
		List<ProductType> productTypeList = jdbcTemplate.query(sql, new ProductTypeRowMapper());
		if(productTypeList == null) {
			return null;
		} else {
			return productTypeList;
		}
	}
	
	/**
     * 內部類別，把結果集轉為 ProductType 物件
     */
    private class ProductTypeRowMapper implements RowMapper<ProductType> {
        @Override
        public ProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ProductType productType  = new ProductType();
        	productType.setId(rs.getInt("ID"));
        	productType.setName(rs.getString("NAME"));
        	productType.setCreateEmpId(rs.getString("CREATE_EMP_ID"));
        	productType.setCreateEmpName(rs.getString("CREATE_EMP_NAME"));
        	productType.setCreateTime(rs.getDate("CREATE_TIME"));
        	productType.setLastEditEmpId(rs.getString("LAST_EDIT_EMP_ID"));
        	productType.setLastEditEmpName(rs.getString("LAST_EDIT_EMP_NAME"));
        	productType.setLastEditTime(rs.getDate("LAST_EDIT_TIME"));
            return productType;
        }
    }
}
