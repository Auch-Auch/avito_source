package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bc;
import com.yandex.mobile.ads.impl.be;
import com.yandex.mobile.ads.impl.bg;
public final class b implements be<MediatedRewardedAdapter> {
    @NonNull
    private final bg<MediatedRewardedAdapter> a;

    public b(@NonNull bg<MediatedRewardedAdapter> bgVar) {
        this.a = bgVar;
    }

    @Override // com.yandex.mobile.ads.impl.be
    @Nullable
    public final bc<MediatedRewardedAdapter> a(@NonNull Context context) {
        return this.a.a(context, MediatedRewardedAdapter.class);
    }
}
