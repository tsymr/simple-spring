package org.springframework.beans.factory.config;

/**
 * BeanDefinition 存放 bean 的类信息
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:18 AM
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
