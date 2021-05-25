package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class hm {
    @NonNull
    private final Context a;
    @NonNull
    private final String b;
    @NonNull
    private final Cif c = new Cif();

    public hm(@NonNull Context context, @NonNull String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    @Nullable
    public final hj a() {
        Object a3;
        Class<?> a4 = Cif.a(this.b);
        if (a4 == null || (a3 = Cif.a(a4, "getFusedLocationProviderClient", this.a)) == null) {
            return null;
        }
        return new hj(a3);
    }
}
