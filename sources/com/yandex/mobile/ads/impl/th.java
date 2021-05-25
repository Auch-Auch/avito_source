package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.rewarded.a;
public final class th {
    @NonNull
    private final a a;

    public th(@NonNull a aVar) {
        this.a = aVar;
    }

    @Nullable
    public final tg a(@NonNull Context context, @NonNull fo foVar, @Nullable x<String> xVar) {
        bq o = xVar != null ? xVar.o() : null;
        if (o == null) {
            return null;
        }
        if (o.c()) {
            br b = o.b();
            if (b != null) {
                return new ti(context, foVar, b);
            }
            return null;
        }
        bp a3 = o.a();
        if (a3 != null) {
            return new tf(a3, this.a);
        }
        return null;
    }
}
