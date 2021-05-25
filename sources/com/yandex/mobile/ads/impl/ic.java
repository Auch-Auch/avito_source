package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class ic {
    @NonNull
    private final ia a = new ia();

    @NonNull
    public static String a(@Nullable Context context) {
        hz hzVar;
        if (context != null) {
            fz a3 = fy.a().a(context);
            if (a3 != null && a3.i()) {
                hzVar = new hx();
                return hzVar.a();
            }
        }
        hzVar = new hy();
        return hzVar.a();
    }
}
