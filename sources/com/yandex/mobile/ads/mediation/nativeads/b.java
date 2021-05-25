package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.eg;
public final class b {
    private final Context a;

    public b(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @NonNull
    public final String a(int i, int i2) {
        int a3 = eg.a(this.a, i);
        int a4 = eg.a(this.a, i2);
        if (a3 >= 320 || a4 >= 240) {
            return "large";
        }
        return (a3 >= 160 || a4 >= 160) ? "medium" : "small";
    }
}
