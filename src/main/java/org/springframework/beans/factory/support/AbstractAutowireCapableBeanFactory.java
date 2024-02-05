package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * AbstractAutowireCapableBeanFactory
 * 继承AbstractBeanFactory 并重写其中createBean方法
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/4 11:43 AM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    /**
     * 获取beanDefinition的类信息，然后根据类信息实例化bean
     * 再将bean放入单例bean容器singletonObjects中
     * 在返回bean对象
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 创建beans实例
     *
     * @param beanDefinition bean的信息
     * @param beanName       bean的名称
     * @param args           参数
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        // 构造方法
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取类的所有构造方法
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 遍历构造方法 根据传入的参数 获取相应的构造方法
        for (Constructor ctor : declaredConstructors) {
            // 获取构造方法的参数
            Class[] parameterTypes = ctor.getParameterTypes();
            // 比较构造方法的参数和传入的参数是否一致，如果一致则为要获取的构造方法
            if (null != args && ctor.getParameterTypes().length == args.length) {
                boolean target = true;
                for (int i = 0; i < args.length; ++i) {
                    Class parameterType = parameterTypes[i];
                    Object arg = args[i];
                    if (!parameterType.equals(arg.getClass())) {
                        target = false;
                    }
                }

                if (target) {
                    constructorToUse = ctor;
                    break;
                }
            }
        }
        // 通过构造方法获取实例
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 设置bean属性值以及依赖注入
     *
     * @param beanName       beanName
     * @param bean           bean对象
     * @param beanDefinition bean信息
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            // 获取bean信息中的属性和属性值
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            // 遍历属性
            for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
                // 获取属性名
                String name = propertyValue.getName();
                // 获取属性值
                Object value = propertyValue.getValue();
                // 如果属性为bean则通过getBean获取
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 设置bean的属性相应的值
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
