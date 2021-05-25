package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class uo extends tc<VideoAd, List<VideoAd>> {
    @NonNull
    private final us a = new us();

    public uo(@NonNull Context context, @NonNull String str, @NonNull tb.a<List<VideoAd>> aVar, @NonNull VideoAd videoAd, @NonNull hw<VideoAd, List<VideoAd>> hwVar) {
        super(context, 0, str, aVar, videoAd, hwVar);
    }

    @Override // com.yandex.mobile.ads.impl.tc
    public final sa<List<VideoAd>> a(@NonNull rx rxVar, int i) {
        tu a3 = this.a.a(rxVar);
        if (a3 == null) {
            return sa.a(new tx("Can't parse VAST response."));
        }
        List<VideoAd> b = a3.a().b();
        if (b.isEmpty()) {
            return sa.a(new tw());
        }
        return sa.a(b, null);
    }
}
