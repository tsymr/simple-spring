package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * BeanFactory 定义获取bean方法
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:34 AM
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
