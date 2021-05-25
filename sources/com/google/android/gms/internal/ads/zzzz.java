package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
public final class zzzz extends zzyk {
    private final VideoController.VideoLifecycleCallbacks zzadp;

    public zzzz(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzadp = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzyl
    public final void onVideoEnd() {
        this.zzadp.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzyl
    public final void onVideoMute(boolean z) {
        this.zzadp.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.ads.zzyl
    public final void onVideoPause() {
        this.zzadp.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzyl
    public final void onVideoPlay() {
        this.zzadp.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzyl
    public final void onVideoStart() {
        this.zzadp.onVideoStart();
    }
}
