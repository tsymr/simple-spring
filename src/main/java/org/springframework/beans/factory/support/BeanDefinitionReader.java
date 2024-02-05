package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * BeanDefinitionReader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 11:32 AM
 */
public interface BeanDefinitionReader {

    /**
     * 定义beanDefinition注册表获取方法
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 定义获取ResourceLoader方法
     *
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 定义扫描bean的方法
     *
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
