package com.ktp.loglib;

public class StackTraceIndices {
    public static final int CUSTOM_TIMBER_INDEX = 4;  // 获取调用者的堆栈信息，索引 3 处通常是调用 CustomTimber.d() 方法的代码行
    public static final int CUSTOM_TAG_TREE_INDEX = 6; // 如果不是提供模块提供给其他模块调用，两个值都减一。
}
