package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.ad.Creative;
import com.yandex.mobile.ads.video.models.ad.CreativeConfigurator;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.HashMap;
import java.util.List;
public final class vu {
    @NonNull
    private final vv a = new vv();
    @NonNull
    private final VideoAd b;

    public vu(@NonNull VideoAd videoAd) {
        this.b = videoAd;
    }

    public final void a(@NonNull VideoAd videoAd) {
        List<Creative> creatives = this.b.getCreatives();
        HashMap hashMap = new HashMap();
        for (Creative creative : creatives) {
            hashMap.putAll(creative.getTrackingEvents());
        }
        for (Creative creative2 : videoAd.getCreatives()) {
            CreativeConfigurator creativeConfigurator = new CreativeConfigurator(creative2);
            creativeConfigurator.addIcons(vv.a(creative2, creatives));
            creativeConfigurator.addTrackingEvents(hashMap);
        }
    }
}
