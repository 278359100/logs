package com.pos.loglib;

import java.io.IOException;
import java.util.Set;

import timber.log.Timber;

public class CallTimber {
    public static void start(String configFilePath) {
        final boolean debug = true;

        try {
            // 初始化LogConfig，读取配置文件中的标签信息
            LogConfig.init(configFilePath);
            Set<String> allowedTags = LogConfig.getAllowedTags(); // 获取允许的标签列表

            if (debug) {
                // Log.d(CallTimber.class.getName(),"DEBUG");
                Timber.plant(new CustomTagTree(allowedTags));
            } else {
                // Log.d(CallTimber.class.getName(),"RELEASE");
                Timber.plant(new Timber.DebugTree());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
