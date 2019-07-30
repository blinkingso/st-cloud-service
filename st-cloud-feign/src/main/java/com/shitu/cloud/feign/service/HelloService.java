package com.shitu.cloud.feign.service;

import com.shitu.cloud.feign.service.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author andrew
 * @date 2019/04/27
 */
@FeignClient(value = "st-cloud-ribbon", fallback = HelloServiceHystrix.class)
public interface HelloService {

    @RequestMapping(value = "/api/hello/v", method = RequestMethod.GET)
    String sayHello();

    @PostMapping(value = "/api/user/register", produces = {"text/plain"})
    boolean register(@RequestParam("user") String user);
}
