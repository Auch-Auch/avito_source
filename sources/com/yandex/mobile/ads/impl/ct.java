package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
import java.util.Map;
public final class ct {
    @NonNull
    private final ht a;
    @Nullable
    private hv.a b;
    @NonNull
    private final cv c = new cv();
    @Nullable
    private fo d;

    public ct(@NonNull Context context) {
        this.a = ht.a(context);
    }

    private hv b(@NonNull Map<String, Object> map) {
        fo foVar = this.d;
        if (foVar != null) {
            map.put(AppEventsConstants.EVENT_PARAM_AD_TYPE, foVar.a().a());
            String e = this.d.e();
            if (e != null) {
                map.put("block_id", e);
            }
            map.putAll(cv.a(this.d.c()));
        }
        hv.a aVar = this.b;
        if (aVar != null) {
            map.putAll(aVar.a());
        }
        return new hv(hv.b.AD_LOADING_RESULT, map);
    }

    public final void a(@NonNull fo foVar) {
        this.d = foVar;
    }

    public final void a(@NonNull hv.a aVar) {
        this.b = aVar;
    }

    private void a(@NonNull Map<String, Object> map) {
        this.a.a(b(map));
    }

    public final void a() {
        a(a.k0("status", "success"));
    }

    public final void a(@NonNull AdRequestError adRequestError) {
        HashMap k0 = a.k0("status", "error");
        k0.put("failure_reason", adRequestError.getDescription());
        a(k0);
    }
}
