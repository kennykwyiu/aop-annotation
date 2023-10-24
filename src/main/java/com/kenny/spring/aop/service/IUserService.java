package com.kenny.spring.aop.service;

public interface IUserService {
    public void createUser() throws InterruptedException;
    public String generateRandomPassword(String type , Integer length);
}
