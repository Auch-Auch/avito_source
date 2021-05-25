package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import com.yandex.mobile.ads.video.VmapError;
public final class tr implements VmapError {
    private final int a;
    @Nullable
    private final String b;

    public tr(int i, @Nullable String str) {
        this.a = i;
        this.b = str;
    }

    @Override // com.yandex.mobile.ads.video.VmapError
    public final int getCode() {
        return this.a;
    }

    @Override // com.yandex.mobile.ads.video.VmapError
    @Nullable
    public final String getDescription() {
        return this.b;
    }
}
