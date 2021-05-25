package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class ho {
    @NonNull
    private final hm a;
    @NonNull
    private final hh b;
    @Nullable
    private hn c;

    public ho(@NonNull Context context, @NonNull String str) {
        this.a = new hm(context, str);
        this.b = new hh(context);
    }

    @Nullable
    private hn c() {
        hj a3 = this.a.a();
        if (a3 != null) {
            boolean a4 = this.b.a();
            boolean b2 = this.b.b();
            if (a4 || b2) {
                return a3.a();
            }
        }
        return null;
    }

    @Nullable
    public final hn a() {
        hn hnVar = this.c;
        return hnVar != null ? hnVar : c();
    }

    public final void b() {
        this.c = c();
        this.c = c();
    }
}
