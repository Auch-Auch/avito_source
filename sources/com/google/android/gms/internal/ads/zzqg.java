package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;
public final class zzqg {
    private final Handler handler;
    private final zzqd zzbmu;

    public zzqg(Handler handler2, zzqd zzqd) {
        this.handler = zzqd != null ? (Handler) zzoz.checkNotNull(handler2) : null;
        this.zzbmu = zzqd;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzbmu != null) {
            this.handler.post(new zzqi(this, str, j, j2));
        }
    }

    public final void zzc(zzjl zzjl) {
        if (this.zzbmu != null) {
            this.handler.post(new zzqf(this, zzjl));
        }
    }

    public final void zzd(zzjl zzjl) {
        if (this.zzbmu != null) {
            this.handler.post(new zzql(this, zzjl));
        }
    }

    public final void zzf(int i, long j) {
        if (this.zzbmu != null) {
            this.handler.post(new zzqk(this, i, j));
        }
    }

    public final void zzb(int i, int i2, int i3, float f) {
        if (this.zzbmu != null) {
            this.handler.post(new zzqj(this, i, i2, i3, f));
        }
    }

    public final void zzc(zzho zzho) {
        if (this.zzbmu != null) {
            this.handler.post(new zzqh(this, zzho));
        }
    }

    public final void zzb(Surface surface) {
        if (this.zzbmu != null) {
            this.handler.post(new zzqm(this, surface));
        }
    }
}
