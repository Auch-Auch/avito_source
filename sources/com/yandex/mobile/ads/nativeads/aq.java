package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.yandex.mobile.ads.impl.ox;
import java.util.ArrayList;
import java.util.List;
public final class aq extends n implements ar {
    public aq(@NonNull Context context, @NonNull ox oxVar, @NonNull w wVar, @NonNull j jVar, @NonNull c cVar) {
        super(context, oxVar, wVar, jVar, cVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.ba
    @NonNull
    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("age");
        arrayList.add(SDKConstants.PARAM_A2U_BODY);
        arrayList.add("call_to_action");
        arrayList.add("icon");
        arrayList.add("rating");
        arrayList.add("sponsored");
        arrayList.add("title");
        return arrayList;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAppInstallAd
    public final void bindAppInstallAd(@Nullable NativeAppInstallAdView nativeAppInstallAdView) throws NativeAdException {
        if (nativeAppInstallAdView != null) {
            nativeAppInstallAdView.a((NativeAppInstallAdView) this);
            a(nativeAppInstallAdView, new as());
        }
    }
}
