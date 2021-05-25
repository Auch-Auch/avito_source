package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzcxw {
    private final zzcdg zzgqx;
    private final zzcxm zzgqy;
    private final zzbsz zzgqz;

    public zzcxw(zzcdg zzcdg) {
        zzcxm zzcxm = new zzcxm();
        this.zzgqy = zzcxm;
        this.zzgqx = zzcdg;
        this.zzgqz = new zzbsz(zzcxm, zzcdg.zzamg()) { // from class: com.google.android.gms.internal.ads.zzcxv
            private final zzcxm zzgqf;
            private final zzaiz zzgqw;

            {
                this.zzgqf = r1;
                this.zzgqw = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzbsz
            public final void zzg(zzuw zzuw) {
                zzcxm zzcxm2 = this.zzgqf;
                zzaiz zzaiz = this.zzgqw;
                zzcxm2.zzg(zzuw);
                if (zzaiz != null) {
                    try {
                        zzaiz.zzc(zzuw);
                    } catch (RemoteException e) {
                        zzbbd.zze("#007 Could not call remote method.", e);
                    }
                    try {
                        zzaiz.onInstreamAdFailedToLoad(zzuw.errorCode);
                    } catch (RemoteException e2) {
                        zzbbd.zze("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final zzcbj zzaqf() {
        return new zzcbj(this.zzgqx, this.zzgqy.zzaqc());
    }

    public final zzcxm zzaqg() {
        return this.zzgqy;
    }

    public final zzbsu zzaqh() {
        return this.zzgqy;
    }

    public final zzbuj zzaqi() {
        return this.zzgqy;
    }

    public final zzbsz zzaqj() {
        return this.zzgqz;
    }

    public final zzbtm zzaqk() {
        return this.zzgqy;
    }

    public final zzut zzaql() {
        return this.zzgqy;
    }

    public final void zzc(zzwl zzwl) {
        this.zzgqy.zzc(zzwl);
    }
}
