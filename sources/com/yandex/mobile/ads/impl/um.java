package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
public final class um extends tc<VastRequestConfiguration, tu> {
    @NonNull
    private final us a = new us();

    public um(@NonNull Context context, @NonNull String str, @NonNull tb.a<tu> aVar, @NonNull VastRequestConfiguration vastRequestConfiguration, @NonNull hw<VastRequestConfiguration, tu> hwVar) {
        super(context, 0, str, aVar, vastRequestConfiguration, hwVar);
    }

    @Override // com.yandex.mobile.ads.impl.tc
    public final sa<tu> a(@NonNull rx rxVar, int i) {
        tu a3 = this.a.a(rxVar);
        if (a3 == null) {
            return sa.a(new tx("Can't parse VAST response."));
        }
        if (!a3.a().b().isEmpty()) {
            return sa.a(a3, null);
        }
        return sa.a(new tw());
    }
}
