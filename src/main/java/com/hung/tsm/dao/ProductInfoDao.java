package com.hung.tsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hung.tsm.model.ProductInfo;

@Repository
public class ProductInfoDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<ProductInfo> getAllProductInfo() throws DataAccessException {
		String sql = "select * from product_info order by type_id, level_id, id asc";
		List<ProductInfo> productInfoList = jdbcTemplate.query(sql, new ProductInfoRowMapper());
		if(productInfoList == null) {
			return null;
		} else {
			return productInfoList;
		}
	}
	
	/**
     * 內部類別，把結果集轉為 ProductInfo 物件
     */
    private class ProductInfoRowMapper implements RowMapper<ProductInfo> {
        @Override
        public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ProductInfo productInfo  = new ProductInfo();
        	productInfo.setId(rs.getInt("ID"));
        	productInfo.setTypeId(rs.getInt("TYPE_ID"));
        	productInfo.setLevelId(rs.getInt("LEVEL_ID"));
        	productInfo.setName(rs.getString("NAME"));
        	productInfo.setCreateEmpId(rs.getString("CREATE_EMP_ID"));
        	productInfo.setCreateEmpName(rs.getString("CREATE_EMP_NAME"));
        	productInfo.setCreateTime(rs.getDate("CREATE_TIME"));
        	productInfo.setLastEditEmpId(rs.getString("LAST_EDIT_EMP_ID"));
        	productInfo.setLastEditEmpName(rs.getString("LAST_EDIT_EMP_NAME"));
        	productInfo.setLastEditTime(rs.getDate("LAST_EDIT_TIME"));
            return productInfo;
        }
    }
}
