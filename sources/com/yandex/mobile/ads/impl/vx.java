package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class vx {
    @NonNull
    private final ud a;
    @NonNull
    private final vl b;

    public vx(@NonNull Context context, @NonNull vl vlVar) {
        this.b = vlVar;
        this.a = ud.a(context);
    }

    public final void a(@NonNull Context context, @NonNull VideoAd videoAd, @NonNull RequestListener<List<VideoAd>> requestListener) {
        this.a.a(context, videoAd, this.b, new vy(videoAd, requestListener));
    }
}
