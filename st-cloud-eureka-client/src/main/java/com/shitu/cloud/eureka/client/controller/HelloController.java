package com.shitu.cloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 * @date 2019/04/27
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/v/{name}")
    public String v1(@PathVariable("name") String name) {
        return "hello: " + name + " from port : " + port;
    }
}
