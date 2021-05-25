package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bc;
import com.yandex.mobile.ads.impl.be;
import com.yandex.mobile.ads.impl.bg;
public final class c implements be<MediatedBannerAdapter> {
    @NonNull
    private final bg<MediatedBannerAdapter> a;

    public c(@NonNull bg<MediatedBannerAdapter> bgVar) {
        this.a = bgVar;
    }

    @Override // com.yandex.mobile.ads.impl.be
    @Nullable
    public final bc<MediatedBannerAdapter> a(@NonNull Context context) {
        return this.a.a(context, MediatedBannerAdapter.class);
    }
}
