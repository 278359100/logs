package com.pos.loglib;

import static com.pos.loglib.StackTraceIndices.CUSTOM_TIMBER_INDEX;

import timber.log.Timber;

public class CustomTimber {

    public static void d(String msg) {
        log(msg, LogLevel.DEBUG);
    }

    public static void e(String msg) {
        log(msg, LogLevel.ERROR);
    }
    private static void log(String msg, LogLevel level) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        // 调试信息，打印堆栈信息
//        for (int i = 0; i < stackTraceElements.length; i++) {
//            Log.d(CustomTimber.class.getName(),"Index %d: %s"+ i + stackTraceElements[i].toString());
//        }
        if (stackTraceElements.length > CUSTOM_TIMBER_INDEX) {
            StackTraceElement ste = stackTraceElements[CUSTOM_TIMBER_INDEX];
            String className = ste.getClassName();
            String simpleClassName = className.substring(className.lastIndexOf('.') + 1);
           // Log.d(CustomTimber.class.getName(),"simpleClassName: "+ simpleClassName);
            String log = build(msg, ste);
            switch (level) {
                case DEBUG:
                    Timber.tag(simpleClassName).d(log);
                    break;
                case ERROR:
                    Timber.tag(simpleClassName).e(log);
                    break;
            }
        }
    }

    private static String build(String msg, StackTraceElement ste) {
        return "(" + ste.getFileName() + ":" + ste.getLineNumber() + "):" + msg + " [Caller: " + ste.getMethodName() + "]";
    }
    private enum LogLevel {
        DEBUG,
        ERROR
    }
}
