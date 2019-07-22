package com.shitu.cloud.mybatis.config;

import com.shitu.cloud.mybatis.bean.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.shitu.cloud.mybatis"})
//@ImportResource("classpath:spring/spring-context.xml")
// @Import(Config.class)  import等价于多个xml文件之间通过import罗织组件
@Profile("dev") // 只有在dev profile激活的时候才会创建相应的bean ， 如果未指定profile 那么所有被bean注解的方法都会被忽略掉
public class Config {

    public static class UserLoginCondition implements Condition {

        @SuppressWarnings("NullableProblems")
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            User user2 = (User) context.getBeanFactory().getBean("user3");

            Environment env = context.getEnvironment();
            String profile = env.getProperty("spring.active.profiles");
//            if (StringUtils.isEmpty(profile)) {
//                return false;
//            }

            if (metadata != null) {
                MultiValueMap<String, Object> mm = metadata.getAllAnnotationAttributes(Bean.class.getName());
                if (mm != null) {
                    Iterator<Map.Entry<String, List<Object>>> iterator = mm.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, List<Object>> next = iterator.next();
                        System.out.println("包含@Bean注解的类：".concat(next.getKey()).concat("======>").concat(next.getValue().toString()));
                    }
                }
            }

            if ("dev".equals(profile)) {
                // 开发环境时指定类
                return true;
            }

            if ("lyblg2".equals(user2.getLyb())) {
                return true;
            }
            return false;
        }
    }

    @Bean("userTest")
    @Primary
    // 基于cglib的代理实现
    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public User user() {
        return new User("lyblg-test-test");
    }
}


