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
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
