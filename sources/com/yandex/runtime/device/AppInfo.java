package com.yandex.runtime.device;

import android.content.Context;
import com.yandex.runtime.Runtime;
public class AppInfo {
    public static String appInfo(String str) {
        try {
            Context applicationContext = Runtime.getApplicationContext();
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
