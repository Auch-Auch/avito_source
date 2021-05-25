package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class ig {
    public static boolean a(@NonNull Context context, @NonNull String str) {
        try {
            return context.getPackageManager().hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public static ResolveInfo a(@NonNull Context context, @NonNull Intent intent) {
        try {
            return context.getPackageManager().resolveService(intent, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
