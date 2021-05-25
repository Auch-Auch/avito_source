package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class vs {
    @NonNull
    private final List<VideoAd> a;
    @NonNull
    private final List<VideoAd> b;

    public vs(@NonNull List<VideoAd> list, @NonNull List<VideoAd> list2) {
        this.a = list;
        this.b = list2;
    }

    @NonNull
    public final List<VideoAd> a() {
        return this.a;
    }

    @NonNull
    public final List<VideoAd> b() {
        return this.b;
    }
}
