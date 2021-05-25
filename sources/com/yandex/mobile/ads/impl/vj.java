package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.avito.android.BuildConfig;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.models.vmap.b;
public final class vj implements vl {
    @NonNull
    private final b a;

    public vj(@NonNull VastRequestConfiguration vastRequestConfiguration) {
        this.a = new b(vastRequestConfiguration);
    }

    @Override // com.yandex.mobile.ads.impl.vl
    @NonNull
    public final String a() {
        String c = this.a.c();
        return TextUtils.isEmpty(c) ? BuildConfig.ADJUST_DEFAULT_TRACKER : c;
    }

    @Override // com.yandex.mobile.ads.impl.vl
    @NonNull
    public final String b() {
        String b = this.a.b();
        return TextUtils.isEmpty(b) ? BuildConfig.ADJUST_DEFAULT_TRACKER : b;
    }
}
