package com.shitu.cloud.eureka.client.service.impl;

import com.shitu.cloud.eureka.client.pojo.User;
import com.shitu.cloud.eureka.client.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author andrew
 * @date 2019/07/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean register(User user) {
        System.out.println("register: " + user);
        return "admin".equals(user.getName());
    }

    @Override
    public boolean login(User user) {
        System.out.println("login: " + user);
        return "admin".equals(user.getName());
    }
}
