package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
public final class ic {
    public static boolean pt;

    public static void ac(@NonNull Context context) {
        if (!ae.enabled && !pt) {
            try {
                Integer num = (Integer) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.my.target.debugMode");
                if (num != null && num.intValue() == 1) {
                    ae.enabled = true;
                }
            } catch (Throwable unused) {
            }
            pt = true;
        }
    }
}
