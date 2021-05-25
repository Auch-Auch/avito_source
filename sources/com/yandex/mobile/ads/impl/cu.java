package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
public final class cu {
    @NonNull
    private final x a;
    @NonNull
    private final ht b;
    @Nullable
    private hv.a c;

    public cu(@NonNull Context context, @NonNull x xVar) {
        this.a = xVar;
        this.b = ht.a(context);
    }

    public final void a(@Nullable hv.a aVar) {
        this.c = aVar;
    }

    public final void a() {
        ec ecVar = new ec(new HashMap());
        ecVar.a("adapter", "Yandex");
        ecVar.a("block_id", this.a.d());
        ecVar.a("ad_type_format", this.a.b());
        ecVar.a("product_type", this.a.c());
        ecVar.a("ad_source", this.a.k());
        b a3 = this.a.a();
        ecVar.a(AppEventsConstants.EVENT_PARAM_AD_TYPE, a3 != null ? a3.a() : null);
        hv.a aVar = this.c;
        if (aVar != null) {
            ecVar.a(aVar.a());
        }
        this.b.a(new hv(hv.b.RENDERING_START, ecVar.a()));
    }
}
