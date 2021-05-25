package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public final class fl implements fk {
    private final boolean a;

    public fl(@NonNull View view) {
        this.a = view.isHardwareAccelerated();
    }

    @Override // com.yandex.mobile.ads.impl.fk
    @NonNull
    public final String a() {
        return String.format("supports: {inlineVideo: %s}", Boolean.valueOf(this.a));
    }
}
