package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class ub implements RequestListener<List<VideoAd>> {
    @NonNull
    private final vk a;
    @NonNull
    private final ue b;
    @NonNull
    private final VideoAdRequest c;

    public class a implements RequestListener<List<VideoAd>> {
        @NonNull
        private final RequestListener<List<VideoAd>> b;

        public a(RequestListener<List<VideoAd>> requestListener) {
            this.b = requestListener;
        }

        @Override // com.yandex.mobile.ads.video.RequestListener
        public final void onFailure(@NonNull VideoAdError videoAdError) {
            ub.this.a.a(videoAdError);
            this.b.onFailure(videoAdError);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.yandex.mobile.ads.video.RequestListener
        public final /* synthetic */ void onSuccess(@NonNull List<VideoAd> list) {
            ub.this.a.a();
            this.b.onSuccess(list);
        }
    }

    public ub(@NonNull VideoAdRequest videoAdRequest, @NonNull vl vlVar) {
        this.c = videoAdRequest;
        Context context = videoAdRequest.getContext();
        this.a = new vk(context, vlVar);
        this.b = new ue(context, vlVar);
    }

    @Override // com.yandex.mobile.ads.video.RequestListener
    public final void onFailure(@NonNull VideoAdError videoAdError) {
        RequestListener<List<VideoAd>> requestListener = this.c.getRequestListener();
        if (requestListener != null) {
            requestListener.onFailure(videoAdError);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.video.RequestListener
    public final /* synthetic */ void onSuccess(@NonNull List<VideoAd> list) {
        List<VideoAd> list2 = list;
        RequestListener<List<VideoAd>> requestListener = this.c.getRequestListener();
        if (requestListener != null) {
            this.b.a(list2, new a(requestListener));
        }
    }

    @NonNull
    public final VideoAdRequest a() {
        return this.c;
    }
}
