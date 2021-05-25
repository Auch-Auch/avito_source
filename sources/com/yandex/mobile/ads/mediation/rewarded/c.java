package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bf;
import java.util.Map;
public final class c implements bf<MediatedRewardedAdapter, MediatedRewardedAdapterListener> {
    @Nullable
    private MediatedRewardedAdapter a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object, java.lang.Object, java.util.Map, java.util.Map] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull Context context, @NonNull MediatedRewardedAdapter mediatedRewardedAdapter, @NonNull MediatedRewardedAdapterListener mediatedRewardedAdapterListener, @NonNull Map map, @NonNull Map map2) {
        MediatedRewardedAdapter mediatedRewardedAdapter2 = mediatedRewardedAdapter;
        this.a = mediatedRewardedAdapter2;
        mediatedRewardedAdapter2.loadRewardedAd(context, mediatedRewardedAdapterListener, map, map2);
    }

    public final boolean b() {
        MediatedRewardedAdapter mediatedRewardedAdapter = this.a;
        return mediatedRewardedAdapter != null && mediatedRewardedAdapter.isLoaded();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.bf
    public final /* synthetic */ void a(@NonNull MediatedRewardedAdapter mediatedRewardedAdapter) {
        mediatedRewardedAdapter.onInvalidate();
    }

    @Nullable
    public final MediatedRewardedAdapter a() {
        return this.a;
    }
}
