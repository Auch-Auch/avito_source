package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
public final class zzcdw implements zzadk {
    private final /* synthetic */ zzcep zzfzn;
    private final /* synthetic */ ViewGroup zzfzo;
    private final /* synthetic */ zzcdr zzfzp;

    public zzcdw(zzcdr zzcdr, zzcep zzcep, ViewGroup viewGroup) {
        this.zzfzp = zzcdr;
        this.zzfzn = zzcep;
        this.zzfzo = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zzc(MotionEvent motionEvent) {
        this.zzfzn.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zzse() {
        zzcdr zzcdr = this.zzfzp;
        if (zzcdr.zza(this.zzfzn, zzcdp.zzfyv)) {
            this.zzfzn.onClick(this.zzfzo);
        }
    }
}
