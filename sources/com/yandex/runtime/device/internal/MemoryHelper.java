package com.yandex.runtime.device.internal;

import android.app.ActivityManager;
import com.yandex.runtime.Runtime;
public class MemoryHelper {
    public static int getAllowedMemorySize() {
        return ((ActivityManager) Runtime.getApplicationContext().getSystemService("activity")).getMemoryClass();
    }
}
