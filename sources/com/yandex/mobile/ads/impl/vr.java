package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class vr implements hw<VideoAd, List<VideoAd>> {
    @NonNull
    private final vl a;

    public vr(@NonNull vl vlVar) {
        this.a = vlVar;
    }

    @NonNull
    private Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("page_id", this.a.a());
        hashMap.put("imp_id", this.a.b());
        return hashMap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.mobile.ads.impl.sa, int, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@Nullable sa<List<VideoAd>> saVar, int i, @NonNull VideoAd videoAd) {
        hv.c cVar;
        T t;
        Map<String, Object> a3 = a();
        if (204 == i) {
            cVar = hv.c.NO_ADS;
        } else if (saVar == null || (t = saVar.a) == null || i != 200) {
            cVar = hv.c.ERROR;
        } else {
            cVar = t.isEmpty() ? hv.c.NO_ADS : hv.c.SUCCESS;
        }
        a3.put("status", cVar.a());
        return new hv(hv.b.VAST_WRAPPER_RESPONSE, a3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(VideoAd videoAd) {
        return new hv(hv.b.VAST_WRAPPER_REQUEST, a());
    }
}
