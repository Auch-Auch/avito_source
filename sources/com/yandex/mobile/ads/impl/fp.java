package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import com.yandex.mobile.ads.AdActivity;
public final class fp {
    public static void a(Context context) {
        try {
            boolean z = true;
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            ActivityInfo activityInfo = null;
            int length = activityInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (AdActivity.a.equals(activityInfo2.name)) {
                    activityInfo = activityInfo2;
                    break;
                }
                i++;
            }
            if (activityInfo != null) {
                int i2 = activityInfo.configChanges;
                boolean z2 = ((i2 & 512) > 0) & ((i2 & 16) > 0) & true & ((i2 & 32) > 0) & ((i2 & 128) > 0) & ((i2 & 256) > 0);
                if (id.a(13)) {
                    int i3 = activityInfo.configChanges;
                    boolean z3 = z2 & ((i3 & 1024) > 0);
                    if ((i3 & 2048) <= 0) {
                        z = false;
                    }
                    z2 = z3 & z;
                }
                if (z2) {
                    return;
                }
            }
        } catch (Exception unused) {
        }
        throw new IllegalStateException("Ad Activity into the AndroidManifest.xml is integrated wrong");
    }
}
