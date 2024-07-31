package com.pos.loglib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class LogConfig {
    private static Set<String> allowedTags = new HashSet<>();

    public static Set<String> createAllowedTags(List<String> tags) {
        return new HashSet<>(tags);
    }

    public static List<String> readTagsFromConfig(String configFilePath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(configFilePath)) {
            properties.load(inputStream);
        }
        String tagsString = properties.getProperty("tags");
        return Arrays.asList(tagsString.split(","));
    }

    public static void init(String configFilePath) throws IOException {
        List<String> tags = readTagsFromConfig(configFilePath);
        allowedTags = createAllowedTags(tags);
        System.out.println(allowedTags);  // 根据需要打印或处理allowedTags
    }

    public static Set<String> getAllowedTags() {
        return allowedTags;
    }
}
