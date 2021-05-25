package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bf;
import com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter;
import java.util.Map;
public final class d implements bf<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object, java.lang.Object, java.util.Map, java.util.Map] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull Context context, @NonNull MediatedBannerAdapter mediatedBannerAdapter, @NonNull MediatedBannerAdapter.MediatedBannerAdapterListener mediatedBannerAdapterListener, @NonNull Map map, @NonNull Map map2) {
        mediatedBannerAdapter.loadBanner(context, mediatedBannerAdapterListener, map, map2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull MediatedBannerAdapter mediatedBannerAdapter) {
        mediatedBannerAdapter.onInvalidate();
    }
}
