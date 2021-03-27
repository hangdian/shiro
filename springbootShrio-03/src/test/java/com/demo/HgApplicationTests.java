package com.demo;

import com.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HgApplicationTests {
	@Autowired
	UserServiceImpl service;

	@Test
	void contextLoads() {
	}
	@Test
	public void text(){
		System.out.println(service.queryUserByName("cunzhu"));
	}

}
