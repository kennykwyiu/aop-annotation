package com.kenny.spring.aop;

import com.kenny.spring.aop.service.IUserService;
import com.kenny.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IUserService userService = context.getBean("userService", IUserService.class);
        userService.createUser();
    }
}
