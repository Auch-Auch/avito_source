package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
public final class zzaxm extends zzaxu {
    private final /* synthetic */ zzaxk zzdym;

    public zzaxm(zzaxk zzaxk) {
        this.zzdym = zzaxk;
    }

    @Override // com.google.android.gms.internal.ads.zzaxu
    public final void zzuy() {
        zzaax zzaax = new zzaax(this.zzdym.zzvr, this.zzdym.zzbpa.zzbra);
        synchronized (this.zzdym.lock) {
            try {
                zzp.zzky();
                zzabc.zza(this.zzdym.zzdxz, zzaax);
            } catch (IllegalArgumentException e) {
                zzbbd.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
