package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
public final class ti implements tg {
    @NonNull
    private final dg a;
    @NonNull
    private final br b;

    public ti(@NonNull Context context, @NonNull fo foVar, @NonNull br brVar) {
        this.a = new dg(context, foVar);
        this.b = brVar;
    }

    @Override // com.yandex.mobile.ads.impl.tg
    public final void a() {
        this.a.a(this.b.a());
    }
}
