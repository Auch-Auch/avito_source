package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
public final class b implements ck {
    @NonNull
    private WeakReference<e> a;

    public b(@NonNull e eVar) {
        this.a = new WeakReference<>(eVar);
    }

    @Override // com.yandex.mobile.ads.impl.ck
    public final boolean a() {
        e eVar = this.a.get();
        return eVar != null && !eg.d(eVar);
    }
}
