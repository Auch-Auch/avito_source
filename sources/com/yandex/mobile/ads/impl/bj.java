package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.yandex.mobile.ads.impl.hv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class bj {
    @NonNull
    private final fo a;
    @NonNull
    private final cv b = new cv();
    @Nullable
    private final x c;

    public bj(@NonNull fo foVar, @Nullable x xVar) {
        this.a = foVar;
        this.c = xVar;
    }

    public final void a(@NonNull Context context, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        a(context, hv.b.CLICK, bnVar, map);
    }

    public final void b(@NonNull Context context, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        a(context, hv.b.IMPRESSION_TRACKING_START, bnVar, map);
        a(context, hv.b.IMPRESSION_TRACKING_SUCCESS, bnVar, map);
    }

    public final void c(@NonNull Context context, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        a(context, hv.b.ADAPTER_AUTO_REFRESH, bnVar, map);
    }

    public final void d(@NonNull Context context, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        a(context, hv.b.ADAPTER_RESPONSE, bnVar, map);
    }

    public final void e(@NonNull Context context, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        a(context, hv.b.ADAPTER_ACTION, bnVar, map);
    }

    public final void f(@NonNull Context context, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        a(context, hv.b.ADAPTER_INVALID, bnVar, map);
    }

    public final void a(@NonNull Context context, @NonNull bn bnVar) {
        a(context, hv.b.ADAPTER_REQUEST, bnVar, Collections.emptyMap());
    }

    public final void a(@NonNull Context context, @NonNull bn bnVar, @Nullable x xVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("reward_info", bk.a(xVar));
        a(context, hv.b.REWARD, bnVar, hashMap);
    }

    private void a(@NonNull Context context, @NonNull hv.b bVar, @NonNull bn bnVar, @NonNull Map<String, Object> map) {
        Map<String, Object> a3 = a(bnVar);
        a3.putAll(map);
        ht.a(context).a(new hv(bVar, a3));
    }

    @NonNull
    private Map<String, Object> a(@NonNull bn bnVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("block_id", this.a.e());
        hashMap.put(AppEventsConstants.EVENT_PARAM_AD_TYPE, this.a.a().a());
        hashMap.put("adapter", bnVar.a());
        hashMap.put("adapter_parameters", bnVar.b());
        hashMap.putAll(cv.a(this.a.c()));
        ec ecVar = new ec(hashMap);
        x xVar = this.c;
        ecVar.a("ad_source", xVar != null ? xVar.k() : null);
        return ecVar.a();
    }
}
