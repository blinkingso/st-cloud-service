package com.shitu.cloud.mybatis.aop;

import java.lang.annotation.*;

/**
 * 测试aop之aspect表达式的注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AopAnnotationPerform {
}
