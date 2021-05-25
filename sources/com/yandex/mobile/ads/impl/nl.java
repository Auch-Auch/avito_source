package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.j;
import com.yandex.mobile.ads.nativeads.o;
import com.yandex.mobile.ads.nativeads.p;
import com.yandex.mobile.ads.nativeads.t;
public final class nl {
    @NonNull
    private final fo a;
    @NonNull
    private final o b = new o();
    @NonNull
    private final ni c = new ni();

    public nl(@NonNull fo foVar) {
        this.a = foVar;
    }

    public final void a(@NonNull Context context, @NonNull p pVar, @NonNull j jVar, @NonNull t tVar, @NonNull nj njVar) {
        nh a3 = ni.a(this.a.p());
        if (a3 != null) {
            a3.a(context, pVar, jVar, tVar, njVar);
        } else {
            njVar.a(v.a);
        }
    }
}
