package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.ArrayList;
import java.util.List;
public final class wa {
    @NonNull
    private final vx a;
    @NonNull
    private final List<VideoAd> b = new ArrayList();
    @Nullable
    private RequestListener<List<VideoAd>> c;
    private int d;

    public class a implements RequestListener<List<VideoAd>> {
        private a() {
        }

        private void a() {
            if (wa.this.d == 0 && wa.this.c != null) {
                wa.this.c.onSuccess(wa.this.b);
            }
        }

        @Override // com.yandex.mobile.ads.video.RequestListener
        public final void onFailure(@NonNull VideoAdError videoAdError) {
            wa.a(wa.this);
            a();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.yandex.mobile.ads.video.RequestListener
        public final /* synthetic */ void onSuccess(@NonNull List<VideoAd> list) {
            wa.a(wa.this);
            wa.this.b.addAll(list);
            a();
        }

        public /* synthetic */ a(wa waVar, byte b) {
            this();
        }
    }

    public wa(@NonNull Context context, @NonNull vl vlVar) {
        this.a = new vx(context, vlVar);
    }

    public static /* synthetic */ int a(wa waVar) {
        int i = waVar.d;
        waVar.d = i - 1;
        return i;
    }

    public final void a(@NonNull Context context, @NonNull List<VideoAd> list, @NonNull RequestListener<List<VideoAd>> requestListener) {
        if (list.isEmpty()) {
            requestListener.onSuccess(this.b);
            return;
        }
        this.c = requestListener;
        for (VideoAd videoAd : list) {
            this.d++;
            this.a.a(context, videoAd, new a(this, (byte) 0));
        }
    }
}
