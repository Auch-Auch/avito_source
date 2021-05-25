package com.yandex.mobile.ads.core.identifiers.ad.huawei;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.gq;
import com.yandex.mobile.ads.impl.gr;
public final class c {
    @NonNull
    private final gr a = new gr();

    @Nullable
    public static gq a(@NonNull b bVar) {
        try {
            OpenDeviceIdentifierService a3 = bVar.a();
            if (a3 != null) {
                return gr.a(a3.getOaid(), Boolean.valueOf(a3.isOaidTrackLimited()));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
