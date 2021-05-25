package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.core.identifiers.ad.gms.service.d;
public final class ha implements gv {
    @NonNull
    private final hb a;
    @NonNull
    private final d b;

    public ha(@NonNull Context context) {
        this.a = new hb(context);
        this.b = new d(context);
    }

    @Override // com.yandex.mobile.ads.impl.gv
    @Nullable
    public final gq a() {
        gq a3 = this.a.a();
        return a3 == null ? this.b.a() : a3;
    }
}
