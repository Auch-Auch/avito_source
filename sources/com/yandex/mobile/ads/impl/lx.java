package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.j;
public final class lx implements lv {
    @NonNull
    private final ly a = new ly();
    @NonNull
    private final lz b = new lz();

    @Override // com.yandex.mobile.ads.impl.lv
    @Nullable
    public final mf a(@NonNull MediaView mediaView, @NonNull j jVar, @NonNull at atVar, @Nullable ow owVar) {
        if (owVar != null) {
            if (owVar.a() != null) {
                es esVar = new es(mediaView.getContext(), atVar);
                mediaView.removeAllViews();
                mediaView.addView(esVar, new FrameLayout.LayoutParams(-1, -1));
                return new mn(mediaView, new mh(esVar));
            } else if (owVar.b() != null) {
                ImageView imageView = new ImageView(mediaView.getContext());
                mediaView.removeAllViews();
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                mediaView.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
                return new mm(mediaView, new me(imageView, jVar));
            }
        }
        return null;
    }
}
