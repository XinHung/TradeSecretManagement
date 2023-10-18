package com.hung.tsm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hung.tsm.model.SecurityLevel;

@SpringBootTest
public class SecurityLevelDaoTest {
	@Autowired
	private SecurityLevelDao securityLevelDao;
	
	@Test
	void getAllSecurityTest() {
		List<SecurityLevel> securityList = securityLevelDao.getAllSecurity();
		assertEquals(securityList.get(0).getLevel(), "A");
		assertEquals(securityList.get(1).getLevel(), "B");
		assertEquals(securityList.get(2).getLevel(), "C");
		assertEquals(securityList.get(3).getLevel(), "P");
	}
}
