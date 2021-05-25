package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.j;
public final class lw implements lv {
    @Override // com.yandex.mobile.ads.impl.lv
    @NonNull
    public final mf a(@NonNull MediaView mediaView, @NonNull j jVar, @NonNull at atVar, @Nullable ow owVar) {
        mediaView.removeAllViews();
        return new mg(mediaView);
    }
}
