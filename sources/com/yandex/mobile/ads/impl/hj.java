package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class hj {
    @NonNull
    private final Object a;

    public hj(@NonNull Object obj) {
        this.a = obj;
    }

    @Nullable
    public final hn a() {
        Object a3 = Cif.a(this.a, "getLastLocation", new Object[0]);
        if (a3 != null) {
            return new hn(a3);
        }
        return null;
    }
}
