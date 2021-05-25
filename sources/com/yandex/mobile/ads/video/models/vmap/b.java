package com.yandex.mobile.ads.video.models.vmap;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.vh;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
public final class b {
    @NonNull
    private final AdBreak a;

    public b(@NonNull VastRequestConfiguration vastRequestConfiguration) {
        this.a = vastRequestConfiguration.getAdBreak();
    }

    @NonNull
    public final c a() {
        return this.a.getAdSource().a();
    }

    @Nullable
    public final String b() {
        return this.a.getAdSource().getId();
    }

    @Nullable
    public final String c() {
        vh a3 = this.a.a();
        if (a3 != null) {
            return a3.a();
        }
        return null;
    }

    @Nullable
    public final String d() {
        vh a3 = this.a.a();
        if (a3 != null) {
            return a3.b();
        }
        return null;
    }
}
