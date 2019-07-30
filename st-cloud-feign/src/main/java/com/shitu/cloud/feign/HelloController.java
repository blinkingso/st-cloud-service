package com.shitu.cloud.feign;

import com.shitu.cloud.feign.service.HelloService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author andrew
 * @date 2019/04/27
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/v")
    public String hello() {
        return helloService.sayHello();
    }


    @PostMapping("/register")
    public boolean register(@RequestParam("user") String user) {
        return helloService.register(user);
    }

}
