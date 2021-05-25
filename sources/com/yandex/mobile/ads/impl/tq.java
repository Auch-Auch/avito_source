package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.gn;
import com.yandex.mobile.ads.video.BlocksInfoRequest;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public final class tq {
    private static final Object a = new Object();
    private static volatile tq b;
    @NonNull
    private final fo c;
    @NonNull
    private final gn d;
    @NonNull
    private ud e;
    @NonNull
    private final tl f;
    @NonNull
    private final Executor g = Executors.newSingleThreadExecutor(new dz("YandexMobileAds.VideoAdsImpl"));
    @NonNull
    private final uc h = new uc();
    @NonNull
    private final ua i = new ua();
    @NonNull
    private final gu j = new gu();

    private tq(@Nullable Context context) {
        this.e = ud.a(context);
        fo foVar = new fo(b.VASTVIDEO);
        this.c = foVar;
        this.d = new gn(foVar);
        this.f = new tl(foVar);
    }

    @NonNull
    public static tq a(@Nullable Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new tq(context);
                }
            }
        }
        return b;
    }

    public static /* synthetic */ void b(tq tqVar, final Context context, final tj tjVar) {
        tqVar.g.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.tq.7
            @Override // java.lang.Runnable
            public final void run() {
                tq.this.f.a(context, tjVar);
            }
        });
    }

    public final void a(@NonNull final Context context, @NonNull final to toVar, @NonNull gm gmVar, @NonNull final RequestListener<Vmap> requestListener) {
        a(context, gmVar, new tj() { // from class: com.yandex.mobile.ads.impl.tq.1
            @Override // com.yandex.mobile.ads.impl.tj
            public final void a() {
                tq.this.e.a(context, tq.this.c, toVar, requestListener);
            }

            @Override // com.yandex.mobile.ads.impl.tj
            public final void a(@NonNull VideoAdError videoAdError) {
                requestListener.onFailure(videoAdError);
            }
        });
    }

    public final void a(@NonNull final Context context, @NonNull final VastRequestConfiguration vastRequestConfiguration, @NonNull gm gmVar, @NonNull final RequestListener<tu> requestListener) {
        a(context, gmVar, new tj() { // from class: com.yandex.mobile.ads.impl.tq.2
            @Override // com.yandex.mobile.ads.impl.tj
            public final void a() {
                ua unused = tq.this.i;
                tq.this.e.a(context, tq.this.c, vastRequestConfiguration, ua.a(context, vastRequestConfiguration, requestListener));
            }

            @Override // com.yandex.mobile.ads.impl.tj
            public final void a(@NonNull VideoAdError videoAdError) {
                requestListener.onFailure(videoAdError);
            }
        });
    }

    public final void a(@NonNull Context context, @NonNull final BlocksInfoRequest blocksInfoRequest, @NonNull gm gmVar) {
        a(context, gmVar, new tj() { // from class: com.yandex.mobile.ads.impl.tq.3
            @Override // com.yandex.mobile.ads.impl.tj
            public final void a() {
                tq.this.e.a(blocksInfoRequest, tq.this.c);
            }

            @Override // com.yandex.mobile.ads.impl.tj
            public final void a(@NonNull VideoAdError videoAdError) {
                RequestListener<BlocksInfo> requestListener = blocksInfoRequest.getRequestListener();
                if (requestListener != null) {
                    requestListener.onFailure(videoAdError);
                }
            }
        });
    }

    public final void a(@NonNull Context context, @NonNull final VideoAdRequest videoAdRequest, @NonNull gm gmVar) {
        a(context, gmVar, new tj() { // from class: com.yandex.mobile.ads.impl.tq.4
            @Override // com.yandex.mobile.ads.impl.tj
            public final void a() {
                uc unused = tq.this.h;
                tq.this.e.a(uc.a(videoAdRequest), tq.this.c);
            }

            @Override // com.yandex.mobile.ads.impl.tj
            public final void a(@NonNull VideoAdError videoAdError) {
                RequestListener<List<VideoAd>> requestListener = videoAdRequest.getRequestListener();
                if (requestListener != null) {
                    requestListener.onFailure(videoAdError);
                }
            }
        });
    }

    private void a(@NonNull final Context context, @NonNull final gm gmVar, @NonNull final tj tjVar) {
        this.g.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.tq.5
            @Override // java.lang.Runnable
            public final void run() {
                tq.this.d.a(gmVar, new gn.a() { // from class: com.yandex.mobile.ads.impl.tq.5.1
                    @Override // com.yandex.mobile.ads.impl.gn.a
                    public final void a() {
                        AnonymousClass5 r0 = AnonymousClass5.this;
                        tq.a(tq.this, context, tjVar);
                    }

                    @Override // com.yandex.mobile.ads.impl.gn.a
                    public final void a(@NonNull String str) {
                        tjVar.a(VideoAdError.createInternalError(str));
                    }
                });
            }
        });
    }

    public final void a(@NonNull String str, @NonNull Tracker.ErrorListener errorListener) {
        this.e.a(str, errorListener);
    }

    public static /* synthetic */ void a(tq tqVar, final Context context, final tj tjVar) {
        tqVar.g.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.tq.6
            @Override // java.lang.Runnable
            public final void run() {
                tq.this.j.a(context, new gz() { // from class: com.yandex.mobile.ads.impl.tq.6.1
                    @Override // com.yandex.mobile.ads.impl.gz
                    public final void a(@Nullable gs gsVar) {
                        if (gsVar != null) {
                            tq.this.c.a(gsVar.a());
                            tq.this.c.b(gsVar.b());
                        }
                        AnonymousClass6 r3 = AnonymousClass6.this;
                        tq.b(tq.this, context, tjVar);
                    }
                });
            }
        });
    }
}
