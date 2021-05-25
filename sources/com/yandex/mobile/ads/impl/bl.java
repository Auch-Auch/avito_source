package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class bl {
    @NonNull
    private final cv a = new cv();
    @NonNull
    private fo b;

    public bl(@NonNull fo foVar) {
        this.b = foVar;
    }

    public final void a(@NonNull Context context, @NonNull x xVar) {
        a(context, xVar, hv.b.ADAPTER_REQUEST, Collections.emptyMap());
    }

    public final void b(@NonNull Context context, @NonNull x xVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", hv.c.SUCCESS.a());
        a(context, xVar, hv.b.ADAPTER_RESPONSE, hashMap);
    }

    public final void c(@NonNull Context context, @NonNull x xVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("reward_info", bk.a(xVar));
        a(context, xVar, hv.b.REWARD, hashMap);
    }

    private void a(@NonNull Context context, @NonNull x xVar, @NonNull hv.b bVar, @NonNull Map<String, Object> map) {
        Map<String, Object> a3 = a(xVar);
        a3.putAll(map);
        ht.a(context).a(new hv(bVar, a3));
    }

    @NonNull
    private Map<String, Object> a(@NonNull x xVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("block_id", xVar.d());
        hashMap.put("adapter", "Yandex");
        b a3 = xVar.a();
        hashMap.put(AppEventsConstants.EVENT_PARAM_AD_TYPE, a3 != null ? a3.a() : null);
        hashMap.putAll(cv.a(this.b.c()));
        if (xVar.p() != null && (xVar.p() instanceof oy)) {
            hashMap.put("native_ad_type", a(((oy) xVar.p()).c()));
        }
        ec ecVar = new ec(hashMap);
        ecVar.a("ad_source", xVar.k());
        return ecVar.a();
    }

    @NonNull
    private static String a(@Nullable List<ox> list) {
        NativeAdType b2;
        return (list == null || list.isEmpty() || (b2 = list.get(0).b()) == null) ? "" : b2.getValue();
    }
}
