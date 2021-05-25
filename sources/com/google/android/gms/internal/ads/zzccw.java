package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;
public final class zzccw extends zzyj {
    private final Object lock = new Object();
    @Nullable
    private zzyg zzfyf;
    @Nullable
    private final zzanj zzfyg;

    public zzccw(@Nullable zzyg zzyg, @Nullable zzanj zzanj) {
        this.zzfyf = zzyg;
        this.zzfyg = zzanj;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float getCurrentTime() throws RemoteException {
        zzanj zzanj = this.zzfyg;
        if (zzanj != null) {
            return zzanj.getVideoCurrentTime();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float getDuration() throws RemoteException {
        zzanj zzanj = this.zzfyg;
        if (zzanj != null) {
            return zzanj.getVideoDuration();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzyl zzyl) throws RemoteException {
        synchronized (this.lock) {
            zzyg zzyg = this.zzfyf;
            if (zzyg != null) {
                zzyg.zza(zzyl);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final zzyl zzqj() throws RemoteException {
        synchronized (this.lock) {
            zzyg zzyg = this.zzfyf;
            if (zzyg == null) {
                return null;
            }
            return zzyg.zzqj();
        }
    }
}
