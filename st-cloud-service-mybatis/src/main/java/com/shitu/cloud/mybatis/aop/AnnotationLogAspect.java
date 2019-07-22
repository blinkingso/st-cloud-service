package com.shitu.cloud.mybatis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationLogAspect {

    /**
     * 指定连接点的参数类型
     */
    @Pointcut(value = "execution(* *.perform(..)) && args(Integer, String)")
    public void perform() {
    }

    /**
     * 指定连接点的参数类型
     */
    @Pointcut(value = "execution(* *.perform(..)) && args(Integer)")
    public void perform2() {
    }

    @Before(value = "perform()")
    public void performBefore() {
        System.out.println("指定(Integer, String)参数的perform Before方法");
    }

    @Before(value = "perform2()")
    public void performAfter() {
        System.out.println("指定(Integer)参数的perform After方法");
    }


    /**
     * 限制连接点匹配目标对象为指定类型的类 IUserService接口类型
     */
    @Pointcut(value = "target(com.shitu.cloud.mybatis.service.IUserService)")
    public void performWithTarget() {
    }

    @Before("performWithTarget()")
    public void beforeTarget() {
        System.out.println("限制连接点匹配目标对象为指定类型的类 IUserService接口类型");
    }

    /**
     * 限制连接点匹配指定的类型
     */
    @Pointcut(value = "within(com.shitu.cloud.mybatis.service..*) && @annotation(com.shitu.cloud.mybatis.aop.AopAnnotationPerform)")
    public void pointcutWithIn() {
    }

    @Before(value = "pointcutWithIn()")
    public void withIn() {
        System.out.println("within 限制连接点匹配指定的类型");
    }

    /**
     * 限制连接点带有指定的注解
     */
    @Pointcut(value = "@annotation(AopAnnotationPerform)")
    public void pointcutAnnotation() {
    }

    @Before(value = "pointcutAnnotation()")
    public void beforeLog() {
        System.out.println("限制连接点指定的注解AopAnnotationPerform");
    }

    @Around(value = "pointcutAnnotation()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget());
        MethodInvocationProceedingJoinPoint point = (MethodInvocationProceedingJoinPoint) joinPoint;
        System.out.println(point.getArgs());
        System.out.println(joinPoint.getThis());
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around 执行结束");
    }

}
