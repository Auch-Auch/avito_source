package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bf;
import java.util.Map;
public final class k implements bf<MediatedNativeAdapter, MediatedNativeAdapterListener> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object, java.lang.Object, java.util.Map, java.util.Map] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull Context context, @NonNull MediatedNativeAdapter mediatedNativeAdapter, @NonNull MediatedNativeAdapterListener mediatedNativeAdapterListener, @NonNull Map map, @NonNull Map map2) {
        mediatedNativeAdapter.loadAd(context, mediatedNativeAdapterListener, map, map2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* bridge */ /* synthetic */ void a(@NonNull MediatedNativeAdapter mediatedNativeAdapter) {
    }
}
