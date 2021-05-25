package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.ad.VideoAdConfigurator;
import com.yandex.mobile.ads.video.models.ad.WrapperConfigurationProvider;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class vw {
    @NonNull
    private final vt a = new vt();
    @NonNull
    private final vu b;
    @NonNull
    private final VideoAd c;
    @NonNull
    private final WrapperConfigurationProvider d;

    public vw(@NonNull VideoAd videoAd) {
        this.c = videoAd;
        this.d = new WrapperConfigurationProvider(videoAd);
        this.b = new vu(videoAd);
    }

    @NonNull
    public final List<VideoAd> a(@NonNull List<VideoAd> list) {
        tv wrapperConfiguration = this.d.getWrapperConfiguration();
        if (wrapperConfiguration != null) {
            if (!wrapperConfiguration.b()) {
                list = vt.a(list).a();
            }
            if (!wrapperConfiguration.a() && !list.isEmpty()) {
                list = Collections.singletonList(list.get(0));
            }
            for (VideoAd videoAd : list) {
                this.b.a(videoAd);
            }
            Map<String, List<String>> trackingEvents = this.c.getTrackingEvents();
            for (VideoAd videoAd2 : list) {
                new VideoAdConfigurator(videoAd2).addTrackingEvents(trackingEvents);
            }
        }
        return list;
    }
}
