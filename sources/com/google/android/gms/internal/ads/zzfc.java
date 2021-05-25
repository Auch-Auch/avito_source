package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
public final class zzfc implements Runnable {
    private final /* synthetic */ zzex zzzk;
    private final /* synthetic */ int zzzn;
    private final /* synthetic */ boolean zzzo;

    public zzfc(zzex zzex, int i, boolean z) {
        this.zzzk = zzex;
        this.zzzn = i;
        this.zzzo = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcf.zza zzb = this.zzzk.zzb(this.zzzn, this.zzzo);
        this.zzzk.zzzb = zzb;
        if (zzex.zza(this.zzzn, zzb)) {
            this.zzzk.zza(this.zzzn + 1, this.zzzo);
        }
    }
}
