package com.shitu.cloud.ribbon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author andrew
 * @date 2019/07/24
 */
@Controller
@RequestMapping("/page")
public class UserPageController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "logout-success";
    }
}
