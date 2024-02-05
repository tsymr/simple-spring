package org.springframework.core.io;
import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;



/**
 * DefaultResourceLoader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 11:27 AM
 */
public class DefaultResourceLoader  implements ResourceLoader{

    /**
     * 获取Resource
     *
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        // 路径不能为空
        Assert.notNull(location, "Location must not be null");
        // 如果是 classpath: 则从ClassPathResource中获取 Resource
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // 从网络获取Resource
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 从文件获取Resource
                return new FileSystemResource(location);
            }
        }
    }
}
