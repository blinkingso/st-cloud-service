package com.shitu.cloud.ribbon.service.impl;

import com.shitu.cloud.ribbon.PublishBeanFactory;
import com.shitu.cloud.ribbon.StateEnum;
import com.shitu.cloud.ribbon.service.IPublish;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author andrew
 * @date 2019/04/27
 */
@Service
public class PublishImpl implements IPublish, InitializingBean {

    @Override
    public void publish(String data) {
        System.out.println("create");
    }

    // bean初始化后set到map中
    @Override
    public void afterPropertiesSet() throws Exception {
        PublishBeanFactory.register(StateEnum.create, this);
    }
}
