package org.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 * 定义了一个获取单例对象的接口
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:32 AM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
