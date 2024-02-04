package org.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.bean.UserService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * ApiTest
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:22 AM
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService =(UserService) beanFactory.getBean("userService", "测试");
        System.out.println(userService);
        userService.queryUserInfo();

    }
}
