package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.yandex.mobile.ads.impl.kw;
import com.yandex.mobile.ads.impl.lc;
import com.yandex.mobile.ads.impl.ld;
import com.yandex.mobile.ads.impl.oq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class q {
    @NonNull
    private final a a;
    @NonNull
    private final d b;
    @NonNull
    private final kw c = new kw();
    @NonNull
    private final ld d = new ld();

    public q(@NonNull Context context) {
        a aVar = new a(context, new c());
        this.a = aVar;
        this.b = new d(aVar);
    }

    @NonNull
    public final List<oq> a(@NonNull MediatedNativeAdAssets mediatedNativeAdAssets, @NonNull Map<String, Bitmap> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a("age", mediatedNativeAdAssets.getAge()));
        arrayList.add(a(SDKConstants.PARAM_A2U_BODY, mediatedNativeAdAssets.getBody()));
        arrayList.add(a("call_to_action", mediatedNativeAdAssets.getCallToAction()));
        arrayList.add(a("domain", mediatedNativeAdAssets.getDomain()));
        arrayList.add(a("favicon", this.a.a(map, mediatedNativeAdAssets.getFavicon())));
        arrayList.add(a("icon", this.a.a(map, mediatedNativeAdAssets.getIcon())));
        arrayList.add(a("media", this.b.a(map, mediatedNativeAdAssets.getImage(), mediatedNativeAdAssets.getMedia())));
        arrayList.add(a("price", mediatedNativeAdAssets.getPrice()));
        arrayList.add(a("rating", String.valueOf(mediatedNativeAdAssets.getRating())));
        arrayList.add(a("review_count", mediatedNativeAdAssets.getReviewCount()));
        arrayList.add(a("sponsored", mediatedNativeAdAssets.getSponsored()));
        arrayList.add(a("title", mediatedNativeAdAssets.getTitle()));
        arrayList.add(a("warning", mediatedNativeAdAssets.getWarning()));
        return a(arrayList);
    }

    @NonNull
    private static List<oq> a(List<oq> list) {
        ArrayList arrayList = new ArrayList();
        for (oq oqVar : list) {
            if (oqVar != null) {
                arrayList.add(oqVar);
            }
        }
        return arrayList;
    }

    @Nullable
    private static <T> oq a(@NonNull String str, @Nullable T t) {
        lc a3 = ld.a(str);
        if (t == null || !a3.a(t)) {
            return null;
        }
        return kw.a(str).a(str, t);
    }
}
