package org.springframework.core.io;

/**
 * ResourceLoader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 11:27 AM
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 定义获取Resource
     * @param location
     * @return
     */
    Resource getResource(String location);

}
