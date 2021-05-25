package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
public final class hh {
    @NonNull
    private final Context a;

    public hh(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    public final boolean a() {
        return a("android.permission.ACCESS_COARSE_LOCATION");
    }

    public final boolean b() {
        return a("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean a(@NonNull String str) {
        try {
            return this.a.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
