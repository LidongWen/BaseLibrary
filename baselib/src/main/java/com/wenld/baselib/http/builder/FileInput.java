package com.wenld.baselib.http.builder;

import java.io.File;

/**
 * <p/>
 * Author: 温利东 on 2017/3/17 15:06.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */


public class FileInput {
    public String key;
    public String filename;
    public File file;

    public FileInput(String name, String filename, File file) {
        this.key = name;
        this.filename = filename;
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileInput{" +
                "key='" + key + '\'' +
                ", filename='" + filename + '\'' +
                ", file=" + file +
                '}';
    }
}
