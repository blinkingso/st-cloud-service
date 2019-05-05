package com.shitu.cloud.config.client.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author andrew
 * @date 2019/04/29
 */
@Component
public class ApolloValueProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 更新结果
        final Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            final Annotation[] annotations = field.getAnnotations();
            if (annotations == null || annotations.length == 0) {
                return bean;
            }

            // 设置值
            final Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                // 重新设置值
                field.setAccessible(true);
                System.out.println("before ============" + field.getName());
                ReflectionUtils.setField(field, bean, "这是一个测试功能");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 更新结果
        final Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            final Annotation[] annotations = field.getAnnotations();
            if (annotations == null || annotations.length == 0) {
                return bean;
            }

            // 设置值
            final Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                // 重新设置值
                System.out.println("after  ============" + field.getName());
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, "这是一个测试功能");
            }
        }
        return bean;
    }
}
