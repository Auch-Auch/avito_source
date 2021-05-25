package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class tk implements RequestListener<tu> {
    @NonNull
    private final RequestListener<List<VideoAd>> a;

    public tk(@NonNull RequestListener<List<VideoAd>> requestListener) {
        this.a = requestListener;
    }

    @Override // com.yandex.mobile.ads.video.RequestListener
    public final void onFailure(@NonNull VideoAdError videoAdError) {
        this.a.onFailure(videoAdError);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.video.RequestListener
    public final /* synthetic */ void onSuccess(@NonNull tu tuVar) {
        this.a.onSuccess(tuVar.a().b());
    }
}
