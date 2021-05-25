package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
public final class zzbzh extends zzbxe<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")
    private boolean zzepb;

    public zzbzh(Set<zzbys<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoEnd() {
        zza(zzbzj.zzfst);
    }

    public final void onVideoPause() {
        zza(zzbzk.zzfst);
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzepb) {
            zza(zzbzl.zzfst);
            this.zzepb = true;
        }
        zza(zzbzo.zzfst);
    }

    public final synchronized void onVideoStart() {
        zza(zzbzm.zzfst);
        this.zzepb = true;
    }
}
