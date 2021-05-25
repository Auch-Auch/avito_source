package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class js implements hv.a {
    @Nullable
    private x<String> a;

    public final void a(@NonNull x<String> xVar) {
        this.a = xVar;
    }

    @Override // com.yandex.mobile.ads.impl.hv.a
    @NonNull
    public final Map<String, Object> a() {
        ec ecVar = new ec(new HashMap());
        x<String> xVar = this.a;
        if (xVar != null) {
            String m = xVar.m();
            ecVar.b("ad_id", m != null ? Collections.singletonList(m) : null);
            ecVar.a("ad_source", this.a.k());
            if (!(this.a.n() != null)) {
                ecVar.a("ad_type_format", this.a.b());
                ecVar.a("product_type", this.a.c());
            }
        }
        return ecVar.a();
    }
}
