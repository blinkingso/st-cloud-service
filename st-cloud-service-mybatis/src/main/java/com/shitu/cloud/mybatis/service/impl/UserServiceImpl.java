package com.shitu.cloud.mybatis.service.impl;

import com.shitu.cloud.mybatis.aop.AopAnnotationPerform;
import com.shitu.cloud.mybatis.bean.User;
import com.shitu.cloud.mybatis.service.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public void register() {
        System.out.println("user register");
    }

    @Override
    public void perform() {
        System.out.println("perform()");
    }

    @Override
    public void perform(int number) {
        System.out.println("perform(int number)=====>" + number);
    }

    @Override
    public void perform(Integer number, String path) {
        System.out.println("perform(Integer number, String path)=====>" + path);
    }

    @AopAnnotationPerform
    @Override
    public void perform(User user) {
        System.out.println("perform(User user)==========>" + user);
    }
}
