package com.shitu.cloud.feign.service;

import com.shitu.cloud.feign.service.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author andrew
 * @date 2019/04/27
 */
@FeignClient(value = "st-cloud-eureka-client", fallback = HelloServiceHystrix.class)
public interface HelloService {

    @RequestMapping("/hello/v/{name}")
    String sayHello(@PathVariable("name") String name);
}
