package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
public final class hk {
    private static final Object a = new Object();
    private static volatile hi b;

    @NonNull
    public static he a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new hi(context, "com.google.android.gms.location.LocationServices");
                }
            }
        }
        return b;
    }
}
