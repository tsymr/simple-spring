package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * DefaultListableBeanFactory
 * <p>
 * 继承AbstractAutowireCapableBeanFactory 并实现 BeanDefinitionRegistry
 * 实现BeanDefinitionRegistry接口中的registerBeanDefinition方法 定义一个BeanDefinition map存放bean的类信息等信息
 * 实现AbstractAutowireCapableBeanFactory类的父类中的getBeanDefinition方法，可以获取到到BeanDefinition信息
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:49 AM
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 向beanDefinitionMap添加bean信息
     *
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 根据 beanName 获取 bean信息
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    /**
     * 判断beanDefinitionMap是否已经存在该名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 获取beanDefinitionMap中的所有beanName
     *
     * @return
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
