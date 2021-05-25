package com.yandex.mobile.ads.core.identifiers.ad.gms.service;

import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.gq;
import com.yandex.mobile.ads.impl.gr;
public final class e {
    @NonNull
    private final gr a = new gr();
    @NonNull
    private final b b = new b();

    @Nullable
    public static gq a(@NonNull c cVar) {
        a aVar;
        try {
            IBinder a3 = cVar.a();
            if (a3 == null) {
                return null;
            }
            IInterface queryLocalInterface = a3.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface instanceof a) {
                aVar = (a) queryLocalInterface;
            } else {
                aVar = new GmsServiceAdvertisingInfoReader(a3);
            }
            return gr.a(aVar.readAdvertisingId(), aVar.readAdTrackingLimited());
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
