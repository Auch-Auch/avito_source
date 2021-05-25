package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public class iy implements ja {
    private final ev a;

    public iy(@NonNull ev evVar) {
        this.a = evVar;
        evVar.setId(2);
    }

    @Override // com.yandex.mobile.ads.impl.ja
    public void a(@NonNull String str) {
        this.a.b(str);
    }

    @Override // com.yandex.mobile.ads.impl.ja
    public void b() {
        this.a.g();
    }

    @Override // com.yandex.mobile.ads.impl.ja
    public void a(@NonNull er erVar) {
        this.a.setHtmlWebViewListener(erVar);
    }
}
