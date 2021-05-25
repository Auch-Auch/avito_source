package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.impl.ds;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
import java.util.Map;
public abstract class cy<T> implements hw<fo, x<T>> {
    @NonNull
    private final cv a = new cv();
    @NonNull
    private final cw b = new cw();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.mobile.ads.impl.sa, int, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@Nullable sa saVar, int i, @NonNull fo foVar) {
        return new hv(hv.b.RESPONSE, a(foVar, saVar, i));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@NonNull fo foVar) {
        return new hv(hv.b.REQUEST, a(foVar));
    }

    @NonNull
    public Map<String, Object> a(@NonNull fo foVar) {
        HashMap hashMap = new HashMap();
        a(hashMap, foVar);
        hashMap.put("block_id", foVar.e());
        hashMap.put(AppEventsConstants.EVENT_PARAM_AD_TYPE, foVar.a().a());
        hashMap.put("is_passback", Boolean.valueOf(foVar.r() == ds.a.b));
        return hashMap;
    }

    @NonNull
    public Map<String, Object> a(@NonNull fo foVar, @Nullable sa<x<T>> saVar, int i) {
        String str;
        T t;
        T t2;
        HashMap hashMap = new HashMap();
        ec ecVar = new ec(new HashMap());
        ecVar.a("block_id", foVar.e());
        ecVar.a(AppEventsConstants.EVENT_PARAM_AD_TYPE, foVar.a().a());
        if (!(saVar == null || (t2 = saVar.a) == null || t2.n() != null)) {
            ecVar.a("ad_type_format", saVar.a.b());
            ecVar.a("product_type", saVar.a.c());
        }
        ecVar.a(i == -1 ? "error_code" : "code", Integer.valueOf(i));
        if (!(saVar == null || (t = saVar.a) == null)) {
            if (t.n() != null) {
                str = "mediation";
            } else if (saVar.a.p() != null) {
                str = "ad";
            }
            ecVar.a(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, str);
            hashMap.putAll(ecVar.a());
            a(hashMap, foVar);
            return hashMap;
        }
        str = "empty";
        ecVar.a(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, str);
        hashMap.putAll(ecVar.a());
        a(hashMap, foVar);
        return hashMap;
    }

    private static void a(@NonNull Map<String, Object> map, @NonNull fo foVar) {
        AdRequest c = foVar.c();
        if (c != null) {
            map.putAll(cv.a(c));
        }
    }
}
