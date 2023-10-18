package com.hung.tsm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hung.tsm.model.User;

@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	void doLoginTest() {
		User user = userDao.getUserByEmpIdAndPwd("22193", "123456");
		assertEquals(user.getEmpName(), "陳信宏");
		assertEquals(user.getEmail(), "wishes10707@gmail.com");
		assertEquals(user.getIsAdmin(), true);
		assertEquals(user.getIsUserAdmin(), false);
	}
}
