package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.VideoAdRequest;
public final class vm implements vl {
    @NonNull
    private final VideoAdRequest a;

    public vm(@NonNull VideoAdRequest videoAdRequest) {
        this.a = videoAdRequest;
    }

    @Override // com.yandex.mobile.ads.impl.vl
    @NonNull
    public final String a() {
        return this.a.getBlocksInfo().getPartnerId();
    }

    @Override // com.yandex.mobile.ads.impl.vl
    @NonNull
    public final String b() {
        return this.a.getBlockId();
    }
}
