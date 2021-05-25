package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.q;
import java.util.ArrayList;
import java.util.List;
public final class re {
    @NonNull
    private final q a = new q();

    @NonNull
    public static List<String> a(@NonNull x<oy> xVar) {
        List<ox> d = d(xVar);
        ArrayList arrayList = new ArrayList();
        for (ox oxVar : d) {
            arrayList.addAll(q.a(oxVar));
        }
        return arrayList;
    }

    @NonNull
    public static List<String> b(@NonNull x<oy> xVar) {
        List<ox> d = d(xVar);
        ArrayList arrayList = new ArrayList();
        for (ox oxVar : d) {
            NativeAdType b = oxVar.b();
            if (b != null) {
                arrayList.add(b.getValue());
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<String> c(@NonNull x<oy> xVar) {
        List<ox> d = d(xVar);
        ArrayList arrayList = new ArrayList();
        for (ox oxVar : d) {
            String e = oxVar.e();
            if (e != null) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    @NonNull
    private static List<ox> d(@NonNull x<oy> xVar) {
        oy p = xVar.p();
        List<ox> c = p != null ? p.c() : null;
        if (c != null) {
            return c;
        }
        return new ArrayList();
    }
}
