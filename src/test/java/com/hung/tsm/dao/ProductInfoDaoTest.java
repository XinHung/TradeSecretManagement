package com.hung.tsm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hung.tsm.model.ProductInfo;

@SpringBootTest
public class ProductInfoDaoTest {
	@Autowired
	private ProductInfoDao productInfoDao;
	
	@Test
	void getAllProductInfoTest() {
		List<ProductInfo> productLevelList = productInfoDao.getAllProductInfo();
		assertEquals(productLevelList.get(0).getName(), "青軸");
		assertEquals(productLevelList.get(1).getName(), "茶軸");
		assertEquals(productLevelList.get(2).getName(), "紅軸");
		assertEquals(productLevelList.get(3).getName(), "黑軸");
		assertEquals(productLevelList.get(12).getName(), "207");
		assertEquals(productLevelList.get(13).getName(), "209");
		assertEquals(productLevelList.get(18).getName(), "M138");
		assertEquals(productLevelList.get(20).getName(), "M359");
		assertEquals(productLevelList.get(24).getName(), "P2024");
		assertEquals(productLevelList.get(36).getName(), "4GA-2");
	}
}
