package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * AbstractAutowireCapableBeanFactory
 * 继承AbstractBeanFactory 并重写其中createBean方法
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:43 AM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 获取beanDefinition的类信息，然后根据类信息实例化bean
     * 再将bean放入单例bean容器singletonObjects中
     * 在返回bean对象
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
