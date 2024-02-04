package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * SimpleInstantiationStrategy
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 2:58 PM
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * JDK 实例化 bean
     * <p>
     * 1. 从beanDefinition获取bean的class信息
     * 2. 判断构造方法是否为空
     * 3. 如果不为空则调用相应的构造方法进行实例化
     * 4. 如果为空则调用默认构造方法实例化
     *
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            Object instance;

            if (null != constructor) {
                instance = clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                instance = clazz.getDeclaredConstructor().newInstance();
            }
            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
