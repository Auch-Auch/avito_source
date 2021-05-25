package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.mx;
import com.yandex.mobile.ads.impl.my;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.ou;
public final class e {
    @NonNull
    private final a a;
    @NonNull
    private final ay b;

    public e(@NonNull a aVar, @NonNull ay ayVar) {
        this.a = aVar;
        this.b = ayVar;
    }

    public final void a(@NonNull oq oqVar, @Nullable ou ouVar, @NonNull ag agVar, @NonNull mx mxVar) {
        if (oqVar.e() && ouVar != null) {
            mxVar.a(ouVar, new my(oqVar, this.a, agVar, this.b));
        }
    }

    public final void a(@NonNull NativeAdUnitView nativeAdUnitView) {
        nativeAdUnitView.a(new h(nativeAdUnitView.getContext(), this.b));
    }
}
