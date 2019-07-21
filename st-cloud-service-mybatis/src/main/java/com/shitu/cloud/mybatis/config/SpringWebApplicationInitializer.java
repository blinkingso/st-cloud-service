package com.shitu.cloud.mybatis.config;

import com.shitu.cloud.mybatis.config.webmvc.RootConfig;
import com.shitu.cloud.mybatis.config.webmvc.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 代替web.xml实现web mvc的功能
 */
public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public SpringWebApplicationInitializer() {
        System.out.println("init");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // 拦截所有的请求
        return new String[]{"/"};
    }
}
