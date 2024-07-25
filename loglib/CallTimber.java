package com.ktp.loglib;

import android.util.Log;

import java.util.Set;

import timber.log.Timber;

public class CallTimber {
       public static void start(){
           final boolean debug = true;
          if (debug) {
//               Log.d(CallTimber.class.getName(),"DEBUG");
               Set<String> allowedTags = LogConfig.ALLOWED_TAGS; // 允许的标签列表
               Timber.plant(new CustomTagTree(allowedTags));
          } else {
//               Log.d(CallTimber.class.getName(),"RELEASE");
               Timber.plant(new Timber.DebugTree());
          }
     }
}
