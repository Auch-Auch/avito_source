package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class vy implements RequestListener<List<VideoAd>> {
    @NonNull
    private final vw a;
    @NonNull
    private final RequestListener<List<VideoAd>> b;

    public vy(@NonNull VideoAd videoAd, @NonNull RequestListener<List<VideoAd>> requestListener) {
        this.b = requestListener;
        this.a = new vw(videoAd);
    }

    @Override // com.yandex.mobile.ads.video.RequestListener
    public final void onFailure(@NonNull VideoAdError videoAdError) {
        this.b.onFailure(videoAdError);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.video.RequestListener
    public final /* synthetic */ void onSuccess(@NonNull List<VideoAd> list) {
        this.b.onSuccess(this.a.a(list));
    }
}
