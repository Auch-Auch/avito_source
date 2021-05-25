package com.yandex.mobile.ads.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tn;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class VideoAdLoader {
    @NonNull
    private final tn a;
    @NonNull
    private final a b = new a();

    public static abstract class OnVideoAdLoadedListener {
        public void onRawVideoAdLoaded(@Nullable String str) {
        }

        public abstract void onVideoAdFailedToLoad(@NonNull VideoAdError videoAdError);

        public abstract void onVideoAdLoaded(@NonNull List<VideoAd> list);
    }

    public VideoAdLoader(@NonNull Context context) {
        this.a = new tn(context);
    }

    public final void cancelLoading() {
        this.b.a();
    }

    public final void loadAd(@NonNull Context context, @NonNull VastRequestConfiguration vastRequestConfiguration) {
        this.a.a(context, vastRequestConfiguration, this.b);
    }

    public final void setOnVideoAdLoadedListener(@Nullable OnVideoAdLoadedListener onVideoAdLoadedListener) {
        this.b.a(onVideoAdLoadedListener);
    }
}
