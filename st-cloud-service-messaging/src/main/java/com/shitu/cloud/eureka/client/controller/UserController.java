package com.shitu.cloud.eureka.client.controller;

import com.shitu.cloud.eureka.client.pojo.User;
import com.shitu.cloud.eureka.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 * @date 2019/07/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return userService.register(user);
    }


    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return userService.login(user);
    }
}
