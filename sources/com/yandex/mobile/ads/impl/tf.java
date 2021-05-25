package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.rewarded.a;
import com.yandex.mobile.ads.rewarded.c;
public final class tf implements tg {
    @NonNull
    private final c a;
    @NonNull
    private final a b;

    public tf(@NonNull bp bpVar, @NonNull a aVar) {
        this.b = aVar;
        this.a = new c(bpVar.a(), bpVar.b());
    }

    @Override // com.yandex.mobile.ads.impl.tg
    public final void a() {
        this.b.a(this.a);
    }
}
