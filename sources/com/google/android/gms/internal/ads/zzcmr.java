package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
public final class zzcmr extends zzaik {
    private final /* synthetic */ zzcmi zzggp;
    private final /* synthetic */ Object zzggq;
    private final /* synthetic */ String zzggr;
    private final /* synthetic */ long zzggs;
    private final /* synthetic */ zzbbq zzggt;

    public zzcmr(zzcmi zzcmi, Object obj, String str, long j, zzbbq zzbbq) {
        this.zzggp = zzcmi;
        this.zzggq = obj;
        this.zzggr = str;
        this.zzggs = j;
        this.zzggt = zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzaih
    public final void onInitializationFailed(String str) {
        synchronized (this.zzggq) {
            this.zzggp.zza(this.zzggr, false, str, (int) (zzp.zzkw().elapsedRealtime() - this.zzggs));
            this.zzggp.zzggh.zzr(this.zzggr, "error");
            this.zzggt.set(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaih
    public final void onInitializationSucceeded() {
        synchronized (this.zzggq) {
            this.zzggp.zza(this.zzggr, true, "", (int) (zzp.zzkw().elapsedRealtime() - this.zzggs));
            this.zzggp.zzggh.zzgk(this.zzggr);
            this.zzggt.set(Boolean.TRUE);
        }
    }
}
