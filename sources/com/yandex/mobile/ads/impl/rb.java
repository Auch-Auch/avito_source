package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class rb implements hv.a {
    @NonNull
    private final re a = new re();
    @Nullable
    private x<oy> b;

    public final void a(@NonNull x<oy> xVar) {
        this.b = xVar;
    }

    @Override // com.yandex.mobile.ads.impl.hv.a
    @NonNull
    public final Map<String, Object> a() {
        ec ecVar = new ec(new HashMap());
        x<oy> xVar = this.b;
        if (xVar != null) {
            List<String> a3 = re.a(xVar);
            if (!a3.isEmpty()) {
                ecVar.b("image_sizes", a3);
            }
            List<String> b2 = re.b(this.b);
            if (!b2.isEmpty()) {
                ecVar.b("native_ad_types", b2);
            }
            List<String> c = re.c(this.b);
            if (!c.isEmpty()) {
                ecVar.b("ad_id", c);
            }
            ecVar.a("ad_source", this.b.k());
            if (!(this.b.n() != null)) {
                ecVar.a("ad_type_format", this.b.b());
                ecVar.a("product_type", this.b.c());
            }
        }
        return ecVar.a();
    }
}
