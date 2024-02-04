package org.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.bean.UserService;

/**
 * ApiTest
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:22 AM
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        //初始化 beanFactory
        BeanFactory beanFactory = new BeanFactory();

        //注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //获取 bean
        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
