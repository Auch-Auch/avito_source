package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bc;
import com.yandex.mobile.ads.impl.be;
import com.yandex.mobile.ads.impl.bg;
public final class j implements be<MediatedNativeAdapter> {
    @NonNull
    private final bg<MediatedNativeAdapter> a;

    public j(@NonNull bg<MediatedNativeAdapter> bgVar) {
        this.a = bgVar;
    }

    @Override // com.yandex.mobile.ads.impl.be
    @Nullable
    public final bc<MediatedNativeAdapter> a(@NonNull Context context) {
        return this.a.a(context, MediatedNativeAdapter.class);
    }
}
