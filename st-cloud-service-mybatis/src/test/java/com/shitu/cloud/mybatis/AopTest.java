package com.shitu.cloud.mybatis;

import com.shitu.cloud.mybatis.bean.User;
import com.shitu.cloud.mybatis.bean.UserConditionTestBean;
import com.shitu.cloud.mybatis.proxy.JdkProxy;
import com.shitu.cloud.mybatis.service.IUserService;
import com.shitu.cloud.mybatis.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@ContextConfiguration("classpath:spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ComponentScan(basePackages = {"com.shitu.cloud.mybatis"})
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class AopTest {

    @Resource
    private IUserService userService;
    @Resource(name = "user2")
    private User user;
    @Autowired
    private User user3;
    @Autowired
    @Qualifier("userProfile")
    private User userProfile;

//    @Autowired
//    @Qualifier("userConditionTestBean")
//    private UserConditionTestBean userConditionTestBean;

    @Autowired
    private User userTest;

    @Autowired
    private Environment environment;

    @Test
    public void testAop() {
        //userService.register();
        System.out.println(user);
        System.out.println(user3);
        System.out.println(userProfile);

        //System.out.println(userConditionTestBean);
        System.out.println(userTest);

        new JdkProxy<IUserService>(new UserServiceImpl()).proxy().register();


        userService.perform();
        userService.perform(123);
        userService.perform(456, "/var/lib/etc");
        userService.perform(user3);

    }
}
