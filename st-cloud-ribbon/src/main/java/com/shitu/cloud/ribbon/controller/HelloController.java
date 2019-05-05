package com.shitu.cloud.ribbon.controller;

import com.shitu.cloud.ribbon.PublishBeanFactory;
import com.shitu.cloud.ribbon.StateEnum;
import com.shitu.cloud.ribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author andrew
 * @date 2019/04/27
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/v")
    public String v() {

        PublishBeanFactory.getBean(StateEnum.processing).publish("andrew");

        return helloService.hello("andrew");
    }
}
