package org.springframework.utils;

/**
 * ClassUtil
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 10:59 AM
 */
public class ClassUtils {

    // 获取加载器
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            System.out.println("currentThread classLoader get error");
        }
        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
