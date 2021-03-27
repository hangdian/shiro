package com.demo;

import com.demo.mapper.UserMapper;
import com.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShiroSpringbootApplicationTests {
    @Autowired
   UserServiceImpl userService;
    @Test
    void contextLoads(){
        System.out.println("hello");
        System.out.println(userService.queryUserByName("cunzhu"));
    }
}
