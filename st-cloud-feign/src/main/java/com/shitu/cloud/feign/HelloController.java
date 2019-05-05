package com.shitu.cloud.feign;

import com.shitu.cloud.feign.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author andrew
 * @date 2019/04/27
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/v")
    public String hello() {
        return helloService.sayHello("andrew");
    }
}
