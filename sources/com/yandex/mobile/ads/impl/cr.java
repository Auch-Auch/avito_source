package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
import java.util.Map;
public final class cr implements cq {
    @NonNull
    private final cv a = new cv();
    @NonNull
    private final ht b;
    @NonNull
    private final x c;
    @Nullable
    private final fo d;
    @Nullable
    private final hv.a e;

    public cr(@NonNull Context context, @NonNull x xVar, @Nullable fo foVar, @Nullable hv.a aVar) {
        this.c = xVar;
        this.d = foVar;
        this.e = aVar;
        this.b = ht.a(context);
    }

    private hv b(@NonNull hv.b bVar, @NonNull Map<String, Object> map) {
        ec ecVar = new ec(map);
        b a3 = this.c.a();
        if (a3 != null) {
            ecVar.a(AppEventsConstants.EVENT_PARAM_AD_TYPE, a3.a());
        } else {
            ecVar.a(AppEventsConstants.EVENT_PARAM_AD_TYPE);
        }
        ecVar.a("block_id", this.c.d());
        ecVar.a("adapter", "Yandex");
        ecVar.a("ad_type_format", this.c.b());
        ecVar.a("product_type", this.c.c());
        ecVar.a("ad_source", this.c.k());
        fo foVar = this.d;
        if (foVar != null) {
            map.putAll(cv.a(foVar.c()));
        }
        hv.a aVar = this.e;
        if (aVar != null) {
            map.putAll(aVar.a());
        }
        return new hv(bVar, ecVar.a());
    }

    @Override // com.yandex.mobile.ads.impl.cq
    public final void a(@NonNull hv.b bVar) {
        this.b.a(b(bVar, new HashMap()));
    }

    @Override // com.yandex.mobile.ads.impl.cq
    public final void a(@NonNull hv.b bVar, @NonNull Map<String, Object> map) {
        this.b.a(b(bVar, map));
    }
}
