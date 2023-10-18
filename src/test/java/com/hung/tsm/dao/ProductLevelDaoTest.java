package com.hung.tsm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hung.tsm.model.ProductLevel;

@SpringBootTest
public class ProductLevelDaoTest {
	@Autowired
	private ProductLevelDao productLevelDao;
	
	@Test
	void getAllProductLevelTest() {
		List<ProductLevel> productLevelList = productLevelDao.getAllProductLevel();
		assertEquals(productLevelList.get(0).getName(), "LEVEL1");
		assertEquals(productLevelList.get(1).getName(), "LEVEL2");
		assertEquals(productLevelList.get(2).getName(), "LEVEL3");
		assertEquals(productLevelList.get(3).getName(), "LEVEL4");
	}
}
