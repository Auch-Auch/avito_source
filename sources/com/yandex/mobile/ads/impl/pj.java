package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.yandex.mobile.ads.impl.ss;
public final class pj extends ss {
    @NonNull
    private final pi a;
    @NonNull
    private final pk b;

    @TargetApi(13)
    public pj(@NonNull rz rzVar, @NonNull ss.b bVar, @NonNull pi piVar, @NonNull pk pkVar) {
        super(rzVar, bVar);
        this.a = piVar;
        this.b = pkVar;
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final ss.c a(String str, ss.d dVar, int i, int i2) {
        return super.a(str, dVar, this.b.a(i), i2);
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final String a(@NonNull String str, int i, int i2, @NonNull ImageView.ScaleType scaleType) {
        return pi.a(str, scaleType);
    }
}
