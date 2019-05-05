package com.shitu.cloud.feign.service.hystrix;

import com.shitu.cloud.feign.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 * @date 2019/04/27
 */
@Component
public class HelloServiceHystrix implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("服务sayHello调用失败");
        return "failed";
    }
}
