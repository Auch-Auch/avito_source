package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class rh {
    @Nullable
    public static Context a(@NonNull Context context) {
        int i = 0;
        while (context instanceof ContextWrapper) {
            int i2 = i + 1;
            if (i >= 10) {
                return null;
            }
            if (context instanceof Activity) {
                return context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            i = i2;
        }
        return null;
    }
}
