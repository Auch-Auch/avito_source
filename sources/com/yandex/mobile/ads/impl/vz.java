package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class vz {
    @NonNull
    private final Context a;
    @NonNull
    private final vl b;
    private int c;

    public vz(@NonNull Context context, @NonNull vl vlVar) {
        this.a = context.getApplicationContext();
        this.b = vlVar;
    }

    public final void a(@NonNull Context context, @NonNull List<VideoAd> list, @NonNull RequestListener<List<VideoAd>> requestListener) {
        int i = this.c + 1;
        this.c = i;
        if (i <= 5) {
            new wa(this.a, this.b).a(context, list, requestListener);
        } else {
            requestListener.onFailure(VideoAdError.createInternalError("Maximum count of VAST wrapper requests exceeded."));
        }
    }
}
