package com.shitu.cloud.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.shitu.cloud.rule.CustomRibbonRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author andrew
 * @date 2019/07/25
 */
@Configuration
// 自定义客户端负载均衡策略
@RibbonClient(name = "rule", configuration = CustomRibbonRule.class)
public class RibbonConfig {

    @Bean
    @Primary
    public IRule rule() {
        return new CustomRibbonRule();
    }
}
