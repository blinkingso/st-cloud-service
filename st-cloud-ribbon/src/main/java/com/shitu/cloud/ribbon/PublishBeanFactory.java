package com.shitu.cloud.ribbon;

import com.shitu.cloud.ribbon.service.IPublish;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author andrew
 * @date 2019/04/27
 */
@Component
public class PublishBeanFactory {

    private static final Map<StateEnum, IPublish> cache = new ConcurrentHashMap<>();

    public static void register(StateEnum key, IPublish value) {
        cache.put(key, value);
    }

    public static IPublish getBean(StateEnum key) {
        Assert.notNull(key, "key为空");

        if (cache.get(key) == null) {
            throw new RuntimeException("缓存不存在");
        }

        return cache.get(key);
    }
}
