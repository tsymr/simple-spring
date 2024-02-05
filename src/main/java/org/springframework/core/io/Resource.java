package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 11:12 AM
 */
public interface Resource {

    /**
     * 定义获取输入流
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
