package org.springframework.beans.factory.config;

/**
 * BeanReference
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 10:18 AM
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
