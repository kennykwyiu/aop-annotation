package com.kenny.spring.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * 用户表Dao
 */
@Repository
public class UserDao {
    public void insert(){
        System.out.println("insert user data");
    }
}
