package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public final class nc implements nb {
    @NonNull
    private final ou a;
    @NonNull
    private final my b;

    public nc(@NonNull ou ouVar, @NonNull my myVar) {
        this.a = ouVar;
        this.b = myVar;
    }

    @Override // com.yandex.mobile.ads.impl.nb
    public final void a(@NonNull View view, @NonNull String str) {
        this.b.a(new ou(this.a.a(), this.a.b(), this.a.c(), str)).onClick(view);
    }
}
