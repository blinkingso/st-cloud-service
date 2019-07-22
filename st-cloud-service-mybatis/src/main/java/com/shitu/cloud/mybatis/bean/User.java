package com.shitu.cloud.mybatis.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean {

    public static int staticPort;

    private String lyb;

    List<User> userList;

    public User(List<User> userList) {
        this.userList = userList;
    }
    public User(String lyb) {
        this.lyb = lyb;
    }

    public String getLyb() {
        return lyb;
    }

    public void setLyb(String lyb) {
        this.lyb = lyb;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("User Bean Name Initializing===>" + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //System.out.println("BeanFactory for User Initialing===>" + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //System.out.println("ApplicationContext for User Initialing===>" + applicationContext);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("User BeanProcessBefore invoked===>" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("User BeanProcessAfter invoked===>" + beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       // System.out.println("bean初始化完成后开始执行");
    }

    @Override
    public String toString() {
        return "User{" +
                "lyb='" + lyb + '\'' +
                '}';
    }
}
