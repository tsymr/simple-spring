package org.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:20 AM
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String beanName){
        return  beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name, beanDefinition);
    }
}
