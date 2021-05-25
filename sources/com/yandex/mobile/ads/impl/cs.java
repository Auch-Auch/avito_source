package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
import java.util.Map;
public final class cs {
    @NonNull
    private final ht a;
    @NonNull
    private final fo b;
    @NonNull
    private final cv c = new cv();
    @Nullable
    private x d;
    @Nullable
    private hv.a e;

    public cs(@NonNull Context context, @NonNull fo foVar) {
        this.b = foVar;
        this.a = ht.a(context);
    }

    @NonNull
    private Map<String, Object> c(@NonNull an anVar) {
        Map<String, Object> a3 = a();
        a3.put("reason", anVar.b().a());
        String a4 = anVar.a();
        if (!TextUtils.isEmpty(a4)) {
            a3.put("asset_name", a4);
        }
        return a3;
    }

    public final void a(@NonNull hv.b bVar) {
        b(bVar, a());
    }

    public final void b(@NonNull an anVar) {
        b(anVar.e(), c(anVar));
    }

    public final void a(@NonNull hv.b bVar, @NonNull Map<String, Object> map) {
        Map<String, Object> a3 = a();
        a3.putAll(map);
        b(bVar, a3);
    }

    private void b(@NonNull hv.b bVar, @NonNull Map<String, Object> map) {
        this.a.a(new hv(bVar, map));
    }

    public final void a(@NonNull an anVar) {
        b(anVar.c(), c(anVar));
    }

    @NonNull
    private Map<String, Object> a() {
        ec ecVar = new ec(new HashMap());
        ecVar.a("adapter", "Yandex");
        x xVar = this.d;
        if (xVar != null) {
            ecVar.a("block_id", xVar.d());
            ecVar.a("ad_type_format", this.d.b());
            ecVar.a("product_type", this.d.c());
            ecVar.a("ad_source", this.d.k());
            b a3 = this.d.a();
            if (a3 != null) {
                ecVar.a(AppEventsConstants.EVENT_PARAM_AD_TYPE, a3.a());
            } else {
                ecVar.a(AppEventsConstants.EVENT_PARAM_AD_TYPE);
            }
        } else {
            ecVar.a("block_id");
            ecVar.a("ad_type_format");
            ecVar.a("product_type");
            ecVar.a("ad_source");
        }
        ecVar.a(cv.a(this.b.c()));
        hv.a aVar = this.e;
        if (aVar != null) {
            ecVar.a(aVar.a());
        }
        return ecVar.a();
    }

    public final void a(@NonNull x xVar) {
        this.d = xVar;
    }

    public final void a(@NonNull hv.a aVar) {
        this.e = aVar;
    }
}
