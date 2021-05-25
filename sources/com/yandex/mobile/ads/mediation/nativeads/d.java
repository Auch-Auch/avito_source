package com.yandex.mobile.ads.mediation.nativeads;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.ov;
import com.yandex.mobile.ads.impl.ow;
import java.util.Map;
public final class d {
    @NonNull
    private final a a;

    public d(@NonNull a aVar) {
        this.a = aVar;
    }

    @Nullable
    public final ow a(@NonNull Map<String, Bitmap> map, @Nullable MediatedNativeAdImage mediatedNativeAdImage, @Nullable MediatedNativeAdMedia mediatedNativeAdMedia) {
        ot a3 = this.a.a(map, mediatedNativeAdImage);
        ov ovVar = mediatedNativeAdMedia != null ? new ov(null, mediatedNativeAdMedia.getAspectRatio()) : null;
        if (a3 == null && ovVar == null) {
            return null;
        }
        return new ow(ovVar, a3);
    }
}
