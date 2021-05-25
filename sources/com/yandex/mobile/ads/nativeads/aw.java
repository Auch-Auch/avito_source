package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.yandex.mobile.ads.impl.ox;
import java.util.ArrayList;
import java.util.List;
public final class aw extends n implements ax {
    public aw(@NonNull Context context, @NonNull ox oxVar, @NonNull w wVar, @NonNull j jVar, @NonNull c cVar) {
        super(context, oxVar, wVar, jVar, cVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.ba
    @NonNull
    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SDKConstants.PARAM_A2U_BODY);
        arrayList.add("domain");
        arrayList.add("sponsored");
        arrayList.add("title");
        return arrayList;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeContentAd
    public final void bindContentAd(@Nullable NativeContentAdView nativeContentAdView) throws NativeAdException {
        if (nativeContentAdView != null) {
            nativeContentAdView.a((NativeContentAdView) this);
            a(nativeContentAdView, new ay());
        }
    }
}
