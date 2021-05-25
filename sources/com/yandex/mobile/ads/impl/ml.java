package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public final class ml<V extends View, T> {
    @NonNull
    private final mk<V, T> a;

    public ml(@NonNull mk<V, T> mkVar) {
        this.a = mkVar;
    }

    public final void a() {
        V a3 = this.a.a();
        if (a3 != null) {
            this.a.a(a3);
        }
    }

    public final boolean b(@NonNull T t) {
        V a3 = this.a.a();
        return a3 != null && this.a.a(a3, t);
    }

    public final void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        if (this.a.a() != null) {
            this.a.a(oqVar, mqVar);
        }
    }

    public final void a(@NonNull T t) {
        V a3 = this.a.a();
        if (a3 != null) {
            this.a.b(a3, t);
            a3.setVisibility(0);
        }
    }
}
