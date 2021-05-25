package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public final class ro {
    @NonNull
    private final ht a;
    @NonNull
    private final cv b;
    @NonNull
    private final fo c;
    @NonNull
    private final List<oq> d;

    public ro(@NonNull Context context, @NonNull fo foVar, @Nullable List<oq> list) {
        this.c = foVar;
        this.d = list == null ? Collections.emptyList() : list;
        this.a = ht.a(context);
        this.b = new cv();
    }

    public final void a(@NonNull List<String> list) {
        List<oq> list2 = this.d;
        ArrayList arrayList = new ArrayList();
        for (oq oqVar : list2) {
            arrayList.add(oqVar.a());
        }
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList2.isEmpty()) {
            HashMap hashMap = new HashMap();
            String e = this.c.e();
            if (e != null) {
                hashMap.put("block_id", e);
            }
            hashMap.put("assets", arrayList2.toArray());
            hashMap.putAll(cv.a(this.c.c()));
            this.a.a(new hv(hv.b.REQUIRED_ASSET_MISSING, hashMap));
        }
    }
}
