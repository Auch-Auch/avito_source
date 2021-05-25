package com.yandex.mobile.ads.core.identifiers.ad.huawei;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.gq;
import com.yandex.mobile.ads.impl.gv;
import com.yandex.mobile.ads.impl.ig;
public final class a implements gv {
    @NonNull
    private final Context a;
    @NonNull
    private final ig b = new ig();
    @NonNull
    private final c c = new c();
    @NonNull
    private final d d = new d();

    public a(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Nullable
    private gq a(@NonNull Intent intent) {
        try {
            b bVar = new b();
            if (!this.a.bindService(intent, bVar, 1)) {
                return null;
            }
            gq a3 = c.a(bVar);
            this.a.unbindService(bVar);
            return a3;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.gv
    @Nullable
    public final gq a() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (ig.a(this.a, intent) != null) {
            return a(intent);
        }
        return null;
    }
}
