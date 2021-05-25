package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.hv;
public final class co implements cp {
    @Override // com.yandex.mobile.ads.impl.cp
    @NonNull
    public final hv.b a() {
        return hv.b.FORCED_IMPRESSION_TRACKING_FAILURE;
    }

    @Override // com.yandex.mobile.ads.impl.cp
    @NonNull
    public final hv.b b() {
        return hv.b.IMPRESSION_TRACKING_START;
    }

    @Override // com.yandex.mobile.ads.impl.cp
    @NonNull
    public final hv.b a(@NonNull an.a aVar) {
        return an.a.SUCCESS == aVar ? hv.b.IMPRESSION_TRACKING_SUCCESS : hv.b.IMPRESSION_TRACKING_FAILURE;
    }
}
