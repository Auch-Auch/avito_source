package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public final class kf implements kd {
    @NonNull
    private final View a;

    public kf(@NonNull View view) {
        this.a = view;
        view.setVisibility(0);
    }

    @Override // com.yandex.mobile.ads.impl.kd
    @NonNull
    public final View a() {
        return this.a;
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final void a(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final void b() {
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final void c() {
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final boolean d() {
        return false;
    }
}
