package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * DefaultSingletonBeanRegistry
 *
 * 实现SingletonBeanRegistry接口 实现其中定义的getSingleton方法(获取单例bean方法)
 * 同时实现了一个受保护的 addSingleton 方法，这个方法可以被继承此类的其他类调用
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:37 AM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 定义一个singletonObjects map来存放单例bean
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
