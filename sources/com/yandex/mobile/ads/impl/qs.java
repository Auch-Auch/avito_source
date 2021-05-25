package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.hv;
public final class qs {
    @NonNull
    private final cq a;
    @NonNull
    private final oh b;
    @NonNull
    private final rh c = new rh();
    @NonNull
    private final qu d;

    public qs(@NonNull Context context, @NonNull cq cqVar, @NonNull oh ohVar) {
        this.a = cqVar;
        this.b = ohVar;
        this.d = new qu(context);
    }

    public final void a(@NonNull Context context, @NonNull pe peVar) {
        Intent a3 = this.d.a(peVar.c());
        if (a3 != null) {
            Context a4 = rh.a(context);
            if (a4 != null) {
                this.a.a(hv.b.DEEPLINK);
                a4.startActivity(a3);
                return;
            }
            return;
        }
        this.b.a(peVar.b());
    }
}
