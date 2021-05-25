package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import java.util.List;
public final class cm {
    @NonNull
    private final dg a;
    @NonNull
    private final cu b;
    @Nullable
    private final List<String> c;

    public cm(@NonNull Context context, @NonNull x xVar, @NonNull fo foVar, @Nullable List<String> list) {
        this.c = list;
        this.a = new dg(context, foVar);
        this.b = new cu(context, xVar);
    }

    public final void a(@NonNull hv.a aVar) {
        this.b.a(aVar);
    }

    public final void a() {
        List<String> list = this.c;
        if (list != null) {
            for (String str : list) {
                this.a.a(str);
            }
        }
        this.b.a();
    }
}
