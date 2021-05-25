package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class r {
    @NonNull
    private final q a;

    public r(@NonNull Context context) {
        this.a = new q(context);
    }

    @NonNull
    public final x<oy> a(@NonNull MediatedNativeAd mediatedNativeAd, @NonNull Map<String, Bitmap> map, @NonNull NativeAdType nativeAdType) {
        List<oq> a3 = this.a.a(mediatedNativeAd.getMediatedNativeAdAssets(), map);
        ox oxVar = new ox();
        oxVar.a(nativeAdType.getValue());
        oxVar.a(a3);
        oy oyVar = new oy();
        oyVar.b(Collections.singletonList(oxVar));
        return new x.a().a((x.a) oyVar).a();
    }
}
