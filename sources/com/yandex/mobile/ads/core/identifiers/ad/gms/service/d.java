package com.yandex.mobile.ads.core.identifiers.ad.gms.service;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.gq;
import com.yandex.mobile.ads.impl.ig;
public final class d {
    @NonNull
    private final Context a;
    @NonNull
    private final ig b = new ig();
    @NonNull
    private final e c = new e();
    @NonNull
    private final f d = new f();

    public d(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Nullable
    private gq a(@NonNull Intent intent) {
        try {
            c cVar = new c();
            if (!this.a.bindService(intent, cVar, 1)) {
                return null;
            }
            gq a3 = e.a(cVar);
            this.a.unbindService(cVar);
            return a3;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public final gq a() {
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (ig.a(this.a, intent) != null) {
            return a(intent);
        }
        return null;
    }
}
