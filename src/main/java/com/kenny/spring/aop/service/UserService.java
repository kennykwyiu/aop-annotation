package com.kenny.spring.aop.service;

import com.kenny.spring.aop.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务
 */
@Service
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;

    public void createUser() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("execute employee creation logic");
        userDao.insert();
    }

    public String generateRandomPassword(String type , Integer length){
        System.out.println("Based on " + type + " method generated "+ length  + " numbers random password");
        return "Zxcquei1";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
