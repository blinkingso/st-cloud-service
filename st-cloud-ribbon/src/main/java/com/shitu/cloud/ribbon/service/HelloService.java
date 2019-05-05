package com.shitu.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author andrew
 * @date 2019/04/27
 */
@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name) {
        return restTemplate.getForObject("http://ST-CLOUD-EUREKA-CLIENT/hello/v/" + name, String.class);
    }

    public String helloError(String name) {
        System.out.println("调用失败 : " + name);

        return "failed ribbon";
    }
}
