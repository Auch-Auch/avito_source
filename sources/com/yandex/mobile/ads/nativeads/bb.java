package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ox;
import java.util.ArrayList;
import java.util.List;
public final class bb extends n implements NativeImageAd {
    public bb(@NonNull Context context, @NonNull ox oxVar, @NonNull w wVar, @NonNull j jVar, @NonNull c cVar) {
        super(context, oxVar, wVar, jVar, cVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.ba
    @NonNull
    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("media");
        return arrayList;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeImageAd
    public final void bindImageAd(@Nullable NativeImageAdView nativeImageAdView) throws NativeAdException {
        if (nativeImageAdView != null) {
            nativeImageAdView.a((NativeImageAdView) this);
            a(nativeImageAdView, new bc());
        }
    }
}
