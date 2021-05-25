package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
public final class qr {
    @NonNull
    public static Set<ot> a(@NonNull ox oxVar) {
        ot b;
        HashSet hashSet = new HashSet();
        for (oq oqVar : oxVar.c()) {
            Object c = oqVar.c();
            if (c instanceof ot) {
                hashSet.add((ot) c);
            }
            if ((c instanceof ow) && (b = ((ow) c).b()) != null) {
                hashSet.add(b);
            }
        }
        return hashSet;
    }
}
