package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.VmapLoader;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
public final class ts implements RequestListener<Vmap> {
    private static final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @Nullable
    private VmapLoader.OnVmapLoadedListener c;

    @Override // com.yandex.mobile.ads.video.RequestListener
    public final void onFailure(@NonNull final VideoAdError videoAdError) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ts.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (ts.a) {
                    if (ts.this.c != null) {
                        ts.this.c.onVmapFailedToLoad(new tr(videoAdError.getCode(), videoAdError.getDescription()));
                    }
                }
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.video.RequestListener
    public final /* synthetic */ void onSuccess(@NonNull Vmap vmap) {
        final Vmap vmap2 = vmap;
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ts.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (ts.a) {
                    if (ts.this.c != null) {
                        ts.this.c.onVmapLoaded(vmap2);
                    }
                }
            }
        });
    }

    public final void a() {
        this.b.removeCallbacksAndMessages(null);
    }

    public final void a(@Nullable VmapLoader.OnVmapLoadedListener onVmapLoadedListener) {
        synchronized (a) {
            this.c = onVmapLoadedListener;
        }
    }
}
