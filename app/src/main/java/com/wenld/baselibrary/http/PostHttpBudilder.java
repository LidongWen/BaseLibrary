package com.wenld.baselibrary.http;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on 2017/3/10 13:28.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class PostHttpBudilder extends HttpBuilder<PostHttpBudilder> {
    private List<FileInput> files = new ArrayList<>();

    public PostHttpBudilder() {
        request_Type = REQUEST_POST;
    }

    public PostHttpBudilder files(String key, Map<String, File> files) {
        for (String filename : files.keySet()) {
            this.files.add(new FileInput(key, filename, files.get(filename)));
        }
        return this;
    }

    public PostHttpBudilder addFile(String name, String filename, File file) {
        files.add(new FileInput(name, filename, file));
        return this;
    }

    public static class FileInput {
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

    public PostHttpBudilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public PostHttpBudilder addParams(String key, String val) {
        if (this.params == null) {
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }
}
