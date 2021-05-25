package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.impl.af;
import com.yandex.mobile.ads.impl.ag;
import com.yandex.mobile.ads.impl.rf;
public class NativeAdUnitLoader {
    @NonNull
    public final Context a;
    @NonNull
    private final v b;

    public NativeAdUnitLoader(@NonNull Context context, @NonNull NativeAdLoaderConfiguration nativeAdLoaderConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        x xVar = new x(context);
        v vVar = new v(applicationContext, nativeAdLoaderConfiguration, xVar);
        this.b = vVar;
        xVar.a(vVar.s());
    }

    public void cancelLoading() {
        this.b.a();
    }

    public void loadAdUnit(@NonNull AdRequest adRequest) {
        this.b.a(adRequest, new rf(this.a), af.AD_UNIT, ag.AD);
    }

    public void setNativeAdUnitLoadListener(@Nullable NativeAdUnitLoadListener nativeAdUnitLoadListener) {
        this.b.a(nativeAdUnitLoadListener);
    }
}
