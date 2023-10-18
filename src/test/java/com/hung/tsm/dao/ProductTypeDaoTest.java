package com.hung.tsm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hung.tsm.model.ProductType;

@SpringBootTest
public class ProductTypeDaoTest {
	@Autowired
	private ProductTypeDao productTypeDao;
	
	@Test
	void getAllProductTypeTest() {
		List<ProductType> productTypeList = productTypeDao.getAllProductType();
		assertEquals(productTypeList.get(0).getName(), "鍵盤");
		assertEquals(productTypeList.get(1).getName(), "滑鼠");
		assertEquals(productTypeList.get(2).getName(), "螢幕");
		assertEquals(productTypeList.get(3).getName(), "主機");
		assertEquals(productTypeList.get(4).getName(), "記憶體");
	}
}
