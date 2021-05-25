package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
public final class bv {
    @NonNull
    private static final Object a = new Object();
    private static volatile rz b;

    @NonNull
    public static rz a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    rz a3 = bw.a(context, 1);
                    b = a3;
                    a3.a();
                }
            }
        }
        return b;
    }
}
