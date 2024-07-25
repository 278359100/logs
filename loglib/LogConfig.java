package com.ktp.loglib;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LogConfig {
    //ContactlessInput2FinishChipOut
    //调用哪些接口
    public static final Set<String> ALLOWED_TAGS = new HashSet<>(Arrays.asList("IPinpadCallbackImplWcg",
            "SearchCardActivity",
            "ShowResultActivity",
            "MainActivity"
    ));
}
