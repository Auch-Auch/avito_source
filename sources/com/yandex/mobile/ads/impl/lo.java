package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public class lo<V extends View, T> implements lm<T> {
    @NonNull
    private final mk<V, T> a;

    public lo(@NonNull mk<V, T> mkVar) {
        this.a = mkVar;
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final void a() {
        V a3 = this.a.a();
        if (a3 != null) {
            this.a.a(a3);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean b(@NonNull T t) {
        V a3 = this.a.a();
        return a3 != null && this.a.a(a3, t);
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final void a(@NonNull T t) {
        V a3 = this.a.a();
        if (a3 != null) {
            this.a.b(a3, t);
            a3.setVisibility(0);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        this.a.a(oqVar, mqVar);
    }
}
