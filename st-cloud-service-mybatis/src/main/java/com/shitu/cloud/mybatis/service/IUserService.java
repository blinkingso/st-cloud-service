package com.shitu.cloud.mybatis.service;

import com.shitu.cloud.mybatis.bean.User;

public interface IUserService {

    void register();

    void perform();

    void perform(int number);

    void perform(Integer number, String path);

    void perform(User user);
}
