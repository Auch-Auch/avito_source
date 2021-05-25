package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.core.identifiers.ad.huawei.a;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public final class gy {
    @NonNull
    private final Executor a = Executors.newSingleThreadExecutor(new dz("YandexMobileAds.AdvertisingId"));
    @NonNull
    private final gv b;
    @NonNull
    private final gv c;

    public gy(@NonNull Context context) {
        this.b = new ha(context);
        this.c = new a(context);
    }

    public final void a(@NonNull final gw gwVar) {
        this.a.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.gy.1
            @Override // java.lang.Runnable
            public final void run() {
                gs a3 = gy.a(gy.this);
                if (a3.a() == null && a3.b() == null) {
                    gwVar.a();
                } else {
                    gwVar.a(a3);
                }
            }
        });
    }

    public static /* synthetic */ gs a(gy gyVar) {
        return new gs(gyVar.b.a(), gyVar.c.a());
    }
}
