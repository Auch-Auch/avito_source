package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class fn implements fk {
    private final boolean a;

    public fn(boolean z) {
        this.a = z;
    }

    @Override // com.yandex.mobile.ads.impl.fk
    @NonNull
    public final String a() {
        return String.format("viewable: %s", Boolean.valueOf(this.a));
    }
}
