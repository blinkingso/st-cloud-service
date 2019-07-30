package com.shitu.cloud.ribbon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author andrew
 * @date 2019/07/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/register", produces = {"text/plain"})
    public boolean register(@RequestParam("user") String user) {
        JSONObject jsonObject = JSON.parseObject(user);
        Boolean result = restTemplate.postForObject("http://ST-CLOUD-SERVICE-MESSAGING/user/register", jsonObject, Boolean.class);
        if (result == null) {
            System.out.println("invoke register error");
            return false;
        }
        return result;
    }

    @PostMapping("/login")
    public boolean login(@RequestParam("user") String user) {
        JSONObject jsonObject = JSON.parseObject(user);
        Boolean result = restTemplate.postForObject("http://ST-CLOUD-SERVICE-MESSAGING/user/login", jsonObject, Boolean.class);
        if (result == null) {
            System.out.println("invoke login error");
            return false;
        }
        return result;
    }
}