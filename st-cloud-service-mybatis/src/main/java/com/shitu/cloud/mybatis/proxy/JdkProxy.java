package com.shitu.cloud.mybatis.proxy;

import java.lang.reflect.Proxy;

public class JdkProxy<T> {

    private T target;

    public JdkProxy(T t) {
        this.target = t;
    }

    /**
     * 通过jdk动态代理的方式生成新的对象代理
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T proxy() {
        return (T) Proxy.newProxyInstance(this.target.getClass().getClassLoader(), target.getClass().getInterfaces(), (object, method, args) -> {
            Object ret = null;
            // 添加log、transaction、权限配置等
            System.out.println("log/transaction/privilege等前置advice");
            ret = method.invoke(target, args);
            System.out.println("日志、事务、权限配置等后置advice");
            return ret;
        });
    }
}
