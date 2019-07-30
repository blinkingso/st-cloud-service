package com.shitu.cloud.eureka.client.service;

import com.shitu.cloud.eureka.client.pojo.User;

/**
 * @author andrew
 * @date 2019/07/23
 */
public interface UserService {

    boolean register(User user);

    boolean login(User user);
}
