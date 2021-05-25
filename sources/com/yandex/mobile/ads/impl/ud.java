package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.rz;
import com.yandex.mobile.ads.impl.uf;
import com.yandex.mobile.ads.video.BlocksInfoRequest;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
public final class ud {
    public static final rz.a a = new rz.a() { // from class: com.yandex.mobile.ads.impl.ud.1
        @Override // com.yandex.mobile.ads.impl.rz.a
        public final boolean a(ry<?> ryVar) {
            return true;
        }
    };
    @NonNull
    private static final Object b = new Object();
    private static volatile ud c;
    private final rz d;

    private ud(rz rzVar) {
        this.d = rzVar;
    }

    @NonNull
    public static ud a(@Nullable Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    rz rzVar = new rz(new su(), new sm(new sx(context, new te()).a()), 1);
                    rzVar.a();
                    c = new ud(rzVar);
                }
            }
        }
        return c;
    }

    public final void a(@NonNull BlocksInfoRequest blocksInfoRequest, @NonNull fo foVar) {
        String partnerId = blocksInfoRequest.getPartnerId();
        String categoryId = blocksInfoRequest.getCategoryId();
        Uri.Builder buildUpon = Uri.parse(uf.a(foVar)).buildUpon();
        buildUpon.appendPath("v1").appendPath("vcset").appendPath(partnerId).appendQueryParameter("video-category-id", categoryId).appendQueryParameter("uuid", foVar.d());
        this.d.a(new uk(blocksInfoRequest, buildUpon.build().toString(), new uf.b(blocksInfoRequest.getRequestListener()), new vn()));
    }

    public final void a(@NonNull ub ubVar, @NonNull fo foVar) {
        this.d.a(uf.c.a(ubVar, foVar));
    }

    public final void a(String str, Tracker.ErrorListener errorListener) {
        this.d.a(new ul(str, new uf.a(errorListener)));
    }

    public final void a(@NonNull Context context, @NonNull fo foVar, @NonNull to toVar, @NonNull RequestListener<Vmap> requestListener) {
        this.d.a(new uj().a(context, foVar, toVar, requestListener));
    }

    public final void a(@NonNull Context context, @NonNull fo foVar, @NonNull VastRequestConfiguration vastRequestConfiguration, @NonNull RequestListener<tu> requestListener) {
        this.d.a(ui.a(context, foVar, vastRequestConfiguration, requestListener));
    }

    public final void a(@NonNull Context context, @NonNull VideoAd videoAd, @NonNull vl vlVar, @NonNull RequestListener<List<VideoAd>> requestListener) {
        this.d.a(new uo(context, videoAd.getVastAdTagUri(), new uf.b(requestListener), videoAd, new vr(vlVar)));
    }
}
