package com.hung.tsm;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SomeTest {
	@Test
	void timeTest() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		Timestamp ts = new Timestamp(calendar.getTime().getTime());
	    System.out.println(ts);
	}
}
