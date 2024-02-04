package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * AbstractBeanFactory
 * <p>
 * 继承DefaultSingletonBeanRegistry
 * 并实现BeanFactory,实现其中的getBean方法
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:38 AM
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 实现BeanFactory的getBean()方法
     * 1.从singletonObjects获取bean，如果获取到就直接返回
     * 2.如果未获取到从getBeanDefinition()方法中获取bean的BeanDefinition并调用createBean实例化bean并返回
     *
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;


}