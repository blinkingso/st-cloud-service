package com.shitu.cloud.mybatis.aop;

import org.aopalliance.aop.Advice;

public class LogAspect implements Advice {

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }

    public void around() {
        System.out.println("around");
    }
}
