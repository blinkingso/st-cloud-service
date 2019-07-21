package com.shitu.cloud.mybatis.bean;

import com.shitu.cloud.mybatis.config.Config;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
//@Conditional(Config.UserLoginCondition.class)
public class UserConditionTestBean {

    public UserConditionTestBean() {
        System.out.println("测试Conditional注解");
    }
}
