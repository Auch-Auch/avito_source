package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;
@TargetApi(14)
public final class zzbcz {
    private final long zzegk = TimeUnit.MILLISECONDS.toNanos(((Long) zzwe.zzpu().zzd(zzaat.zzcmf)).longValue());
    private long zzegl;
    private boolean zzegm = true;

    public final void zza(SurfaceTexture surfaceTexture, zzbcm zzbcm) {
        if (zzbcm != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzegm || Math.abs(timestamp - this.zzegl) >= this.zzegk) {
                this.zzegm = false;
                this.zzegl = timestamp;
                zzayh.zzeaj.post(new zzbcy(this, zzbcm));
            }
        }
    }

    public final void zzyz() {
        this.zzegm = true;
    }
}
