package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.be;
import java.util.List;
public final class ny {
    @NonNull
    public static nx a(@NonNull be beVar, @NonNull List<bo> list) {
        int i;
        if (list.isEmpty()) {
            i = 50;
        } else {
            int c = list.get(0).c();
            for (bo boVar : list) {
                c = Math.max(c, boVar.c());
            }
            i = c;
        }
        return new nx(beVar, i);
    }
}
