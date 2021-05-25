package com.yandex.mobile.ads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ei;
public final class VideoController {
    @NonNull
    private final ei a;

    public VideoController(@NonNull ei eiVar) {
        this.a = eiVar;
    }

    public final void setVideoEventListener(@Nullable VideoEventListener videoEventListener) {
        this.a.a(videoEventListener);
    }
}
