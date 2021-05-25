package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
public final class ex {
    @NonNull
    private final ev a;
    @NonNull
    private final kc b = new kc();

    public ex(@NonNull ev evVar) {
        this.a = evVar;
    }

    public final void a(@Nullable final Map<String, String> map) {
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.ex.1
            @Override // java.lang.Runnable
            public final void run() {
                ex.this.a.setVisibility(0);
                ex.a(ex.this, map);
            }
        });
    }

    public static /* synthetic */ void a(ex exVar, Map map) {
        er erVar = exVar.a.e;
        if (erVar != null) {
            erVar.onAdLoaded();
            erVar.a(exVar.a, map);
        }
    }
}
