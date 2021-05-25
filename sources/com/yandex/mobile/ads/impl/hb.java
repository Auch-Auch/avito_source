package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class hb {
    @NonNull
    private final Context a;
    @NonNull
    private final Cif b = new Cif();
    @NonNull
    private final gr c = new gr();

    public hb(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Nullable
    public final gq a() {
        try {
            Class<?> a3 = Cif.a("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            if (a3 == null) {
                return null;
            }
            Object a4 = Cif.a(a3, "getAdvertisingIdInfo", this.a);
            return gr.a((String) Cif.a(a4, "getId", new Object[0]), (Boolean) Cif.a(a4, "isLimitAdTrackingEnabled", new Object[0]));
        } catch (Throwable unused) {
            return null;
        }
    }
}
