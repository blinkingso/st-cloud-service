package com.shit.cloud.config.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 * @date 2019/04/25
 */
@RestController
public class TestController {


    @GetMapping("/test")
    public String health() {
        return "{\"success\":true}";
    }
}
