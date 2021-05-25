package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.j;
public final class lu {
    @NonNull
    private final ln a;
    @NonNull
    private final at b;
    @NonNull
    private final lv c;

    public lu(@NonNull ln lnVar, @NonNull at atVar, @NonNull lv lvVar) {
        this.a = lnVar;
        this.b = atVar;
        this.c = lvVar;
    }

    @Nullable
    public final mf a(@NonNull MediaView mediaView, @NonNull j jVar) {
        return this.c.a(mediaView, jVar, this.b, this.a.a());
    }
}
