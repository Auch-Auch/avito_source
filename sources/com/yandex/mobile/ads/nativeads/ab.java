package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.af;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.nativeads.ba;
import java.util.ArrayList;
import java.util.List;
public final class ab extends ba implements NativeAdUnit {
    @NonNull
    private final j a;
    @NonNull
    private final List<? extends NativeGenericAd> b;
    @NonNull
    private final bh c;

    public ab(@NonNull Context context, @NonNull List<? extends NativeGenericAd> list, @NonNull j jVar, @NonNull c cVar) {
        super(context, cVar);
        this.b = list;
        this.a = jVar;
        this.c = cVar.c();
        p a3 = cVar.a();
        List<ox> c2 = a3.c().c();
        fo a4 = a3.a();
        String a5 = af.AD_UNIT.a();
        ap apVar = new ap(c2, a4);
        apVar.a(ba.a.CUSTOM);
        apVar.a(a5);
        a(apVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.ba
    @NonNull
    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("sponsored");
        return arrayList;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdUnit
    public final void bindAdUnit(@Nullable NativeAdUnitView nativeAdUnitView) throws NativeAdException {
        if (nativeAdUnitView != null) {
            nativeAdUnitView.a((NativeAdUnitView) this);
            a(nativeAdUnitView, this.a, new ad(), f.a());
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdUnit
    @NonNull
    public final List<? extends NativeGenericAd> getNativeAds() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdUnit
    public final String getSponsored() {
        List<oq> a3 = this.c.a();
        if (a3 == null) {
            return null;
        }
        for (oq oqVar : a3) {
            if ("sponsored".equals(oqVar.a())) {
                return (String) oqVar.c();
            }
        }
        return null;
    }
}
