package org.springframework;

/**
 * BeanDefinition
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:18 AM
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
