package com.shitu.cloud.mybatis.config.webmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * spring beans配置。 扫描注解。之去除mvc的相关配置的扫描。防止重复扫描
 */
@Configuration
@ComponentScan(basePackages = {"com.shitu.cloud.mybatis"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
