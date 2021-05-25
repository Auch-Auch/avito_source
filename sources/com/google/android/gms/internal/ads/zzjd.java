package com.google.android.gms.internal.ads;
public final class zzjd implements zziu {
    private final /* synthetic */ zzjb zzamr;

    private zzjd(zzjb zzjb) {
        this.zzamr = zzjb;
    }

    @Override // com.google.android.gms.internal.ads.zziu
    public final void zzc(int i, long j, long j2) {
        this.zzamr.zzamk.zzb(i, j, j2);
        zzjb.zza(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zziu
    public final void zzel() {
        zzjb.zzgb();
        this.zzamr.zzamq = true;
    }

    @Override // com.google.android.gms.internal.ads.zziu
    public final void zzx(int i) {
        this.zzamr.zzamk.zzy(i);
        zzjb.zzx(i);
    }
}
