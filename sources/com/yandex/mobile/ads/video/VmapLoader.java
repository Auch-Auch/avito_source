package com.yandex.mobile.ads.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tn;
import com.yandex.mobile.ads.impl.to;
import com.yandex.mobile.ads.impl.ts;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
public final class VmapLoader {
    @NonNull
    private final tn a;
    @NonNull
    private final ts b = new ts();

    public static abstract class OnVmapLoadedListener {
        public abstract void onVmapFailedToLoad(@NonNull VmapError vmapError);

        public abstract void onVmapLoaded(@NonNull Vmap vmap);
    }

    public VmapLoader(@NonNull Context context) {
        this.a = new tn(context);
    }

    public final void cancelLoading() {
        this.b.a();
    }

    public final void loadVmap(@NonNull Context context, @NonNull VmapRequestConfiguration vmapRequestConfiguration) {
        this.a.a(context, new to.a("v1", vmapRequestConfiguration.getCategoryId(), vmapRequestConfiguration.getPageId()).a(), this.b);
    }

    public final void setOnVmapLoadedListener(@Nullable OnVmapLoadedListener onVmapLoadedListener) {
        this.b.a(onVmapLoadedListener);
    }
}
