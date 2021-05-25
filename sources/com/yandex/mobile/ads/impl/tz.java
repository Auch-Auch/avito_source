package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class tz implements RequestListener<tu> {
    @NonNull
    private final vk a;
    @NonNull
    private final ue b;
    @NonNull
    private final RequestListener<tu> c;

    public class a implements RequestListener<List<VideoAd>> {
        @NonNull
        private final tu b;
        @NonNull
        private final RequestListener<tu> c;

        public a(tu tuVar, @NonNull RequestListener<tu> requestListener) {
            this.b = tuVar;
            this.c = requestListener;
        }

        @Override // com.yandex.mobile.ads.video.RequestListener
        public final void onFailure(@NonNull VideoAdError videoAdError) {
            tz.this.a.a(videoAdError);
            this.c.onFailure(videoAdError);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.yandex.mobile.ads.video.RequestListener
        public final /* synthetic */ void onSuccess(@NonNull List<VideoAd> list) {
            tz.this.a.a();
            this.c.onSuccess(new tu(new tt(this.b.a().a(), list), this.b.b()));
        }
    }

    public tz(@NonNull Context context, @NonNull vl vlVar, @NonNull RequestListener<tu> requestListener) {
        this.c = requestListener;
        this.a = new vk(context, vlVar);
        this.b = new ue(context, vlVar);
    }

    @Override // com.yandex.mobile.ads.video.RequestListener
    public final void onFailure(@NonNull VideoAdError videoAdError) {
        this.c.onFailure(videoAdError);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.video.RequestListener
    public final /* synthetic */ void onSuccess(@NonNull tu tuVar) {
        tu tuVar2 = tuVar;
        this.b.a(tuVar2.a().b(), new a(tuVar2, this.c));
    }
}
