package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.mediation.base.a;
import java.util.Map;
public final class bc<T extends a> {
    @NonNull
    private final T a;
    @NonNull
    private final bn b;
    @NonNull
    private final bb c;

    public bc(@NonNull T t, @NonNull bn bnVar, @NonNull bb bbVar) {
        this.a = t;
        this.b = bnVar;
        this.c = bbVar;
    }

    @NonNull
    public final T a() {
        return this.a;
    }

    @NonNull
    public final bn b() {
        return this.b;
    }

    @NonNull
    public final Map<String, String> c() {
        return this.c.a(this.b);
    }

    @NonNull
    public final Map<String, Object> a(@NonNull Context context) {
        return this.c.a(context);
    }
}
