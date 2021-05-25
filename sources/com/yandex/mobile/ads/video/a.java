package com.yandex.mobile.ads.video;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tu;
import com.yandex.mobile.ads.video.VideoAdLoader;
public final class a implements RequestListener<tu> {
    private static final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @Nullable
    private VideoAdLoader.OnVideoAdLoadedListener c;

    @Override // com.yandex.mobile.ads.video.RequestListener
    public final void onFailure(@NonNull final VideoAdError videoAdError) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.video.a.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.a) {
                    if (a.this.c != null) {
                        a.this.c.onVideoAdFailedToLoad(videoAdError);
                    }
                }
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.video.RequestListener
    public final /* synthetic */ void onSuccess(@NonNull tu tuVar) {
        final tu tuVar2 = tuVar;
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.video.a.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.a) {
                    if (a.this.c != null) {
                        a.this.c.onRawVideoAdLoaded(tuVar2.b());
                        a.this.c.onVideoAdLoaded(tuVar2.a().b());
                    }
                }
            }
        });
    }

    public final void a() {
        this.b.removeCallbacksAndMessages(null);
    }

    public final void a(@Nullable VideoAdLoader.OnVideoAdLoadedListener onVideoAdLoadedListener) {
        synchronized (a) {
            this.c = onVideoAdLoadedListener;
        }
    }
}
