package com.shitu.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 服务发现
@EnableDiscoveryClient
// 服务注册
@EnableEurekaClient
//feign配置
@EnableFeignClients
// hystrix
@EnableHystrix
public class FeignApplication {

    public static void  main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
