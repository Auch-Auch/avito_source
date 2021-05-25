package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import java.util.List;
import java.util.Map;
public final class rd extends cy<oy> {
    @NonNull
    private final re a = new re();

    @Override // com.yandex.mobile.ads.impl.cy
    @NonNull
    public final Map<String, Object> a(@NonNull fo foVar) {
        Map<String, Object> a3 = super.a(foVar);
        a3.put("image_loading_automatically", Boolean.valueOf(foVar.u()));
        String[] o = foVar.o();
        if (o != null && o.length > 0) {
            a3.put("image_sizes", foVar.o());
        }
        return a3;
    }

    @Override // com.yandex.mobile.ads.impl.cy
    @NonNull
    public final Map<String, Object> a(@NonNull fo foVar, @Nullable sa<x<oy>> saVar, int i) {
        hv.c cVar;
        T t;
        T t2;
        Map<String, Object> a3 = super.a(foVar, saVar, i);
        if (204 == i) {
            cVar = hv.c.NO_ADS;
        } else if (saVar == null || (t2 = saVar.a) == null || i != 200) {
            cVar = hv.c.ERROR;
        } else {
            T t3 = t2;
            cVar = null;
            oy oyVar = (oy) t3.p();
            if (oyVar != null) {
                cVar = (hv.c) oyVar.a().get("status");
            } else if (t3.n() == null) {
                cVar = hv.c.ERROR;
            }
        }
        if (cVar != null) {
            a3.put("status", cVar.a());
        }
        if (!(saVar == null || (t = saVar.a) == null)) {
            List<String> a4 = re.a(t);
            if (!a4.isEmpty()) {
                a3.put("image_sizes", a4.toArray(new String[a4.size()]));
            }
            List<String> b = re.b(saVar.a);
            if (!b.isEmpty()) {
                a3.put("native_ad_types", b.toArray(new String[b.size()]));
            }
        }
        return a3;
    }
}
