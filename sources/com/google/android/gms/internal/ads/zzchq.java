package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
public final class zzchq extends VideoController.VideoLifecycleCallbacks {
    private final zzccv zzfvt;

    public zzchq(zzccv zzccv) {
        this.zzfvt = zzccv;
    }

    private static zzyl zza(zzccv zzccv) {
        zzyg videoController = zzccv.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzqj();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzyl zza = zza(this.zzfvt);
        if (zza != null) {
            try {
                zza.onVideoEnd();
            } catch (RemoteException e) {
                zzbbd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzyl zza = zza(this.zzfvt);
        if (zza != null) {
            try {
                zza.onVideoPause();
            } catch (RemoteException e) {
                zzbbd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzyl zza = zza(this.zzfvt);
        if (zza != null) {
            try {
                zza.onVideoStart();
            } catch (RemoteException e) {
                zzbbd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }
}
