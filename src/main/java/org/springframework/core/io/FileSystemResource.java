package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * FileSystemResource
 * <p>
 * 通过指定文件路径的方式读取文件信息
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/2/5 11:19 AM
 */
public class FileSystemResource implements Resource {

    private final File file;
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();

    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.file.toPath());
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }
}
