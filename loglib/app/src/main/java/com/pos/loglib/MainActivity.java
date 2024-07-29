package com.pos.loglib;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    // 获取配置文件路径
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 将配置文件从res/raw复制到内部存储目录（仅第一次运行时）
        File configFile = new File(getFilesDir(), "config.properties");
        if (!configFile.exists()) {
            try (InputStream inputStream = getResources().openRawResource(R.raw.config);
                 FileOutputStream outputStream = new FileOutputStream(configFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 获取配置文件路径
        String configFilePath = configFile.getAbsolutePath();
        if (configFilePath == null || configFilePath.isEmpty()) {
            System.err.println("Config file path is not set. Please set the 'config.file.path' system property.");
            return;
        }

        // 打印配置文件路径以验证
        System.out.println("Config file path: " + configFilePath);

        // 调用CallTimber的start方法并传入配置文件路径
        CallTimber.start(configFilePath);
        // 使用CustomTimber
        CustomTimber.d("loglib is working");
    }



}
