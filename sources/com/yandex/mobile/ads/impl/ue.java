package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.ArrayList;
import java.util.List;
public final class ue {
    @NonNull
    private final Context a;
    @NonNull
    private final vz b;
    @NonNull
    private final vt c = new vt();
    @NonNull
    private final List<VideoAd> d = new ArrayList();

    public class a implements RequestListener<List<VideoAd>> {
        @NonNull
        private final RequestListener<List<VideoAd>> b;

        public a(RequestListener<List<VideoAd>> requestListener) {
            this.b = requestListener;
        }

        private void a() {
            if (ue.this.d.isEmpty()) {
                this.b.onFailure(VideoAdError.createNoAdError(new tw()));
                return;
            }
            this.b.onSuccess(ue.this.d);
        }

        @Override // com.yandex.mobile.ads.video.RequestListener
        public final void onFailure(@NonNull VideoAdError videoAdError) {
            a();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.yandex.mobile.ads.video.RequestListener
        public final /* synthetic */ void onSuccess(@NonNull List<VideoAd> list) {
            vs a3 = vt.a(list);
            ue.this.d.addAll(a3.a());
            List<VideoAd> b2 = a3.b();
            if (b2.isEmpty()) {
                a();
            } else {
                ue.this.b.a(ue.this.a, b2, this);
            }
        }
    }

    public ue(@NonNull Context context, @NonNull vl vlVar) {
        this.a = context.getApplicationContext();
        this.b = new vz(context, vlVar);
    }

    public final void a(@NonNull List<VideoAd> list, @NonNull RequestListener<List<VideoAd>> requestListener) {
        vs a3 = vt.a(list);
        this.d.addAll(a3.a());
        this.b.a(this.a, a3.b(), new a(requestListener));
    }
}
