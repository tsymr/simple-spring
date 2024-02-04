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

        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
        assertThat(userService).isEqualTo(userService_singleton);
    }
}
