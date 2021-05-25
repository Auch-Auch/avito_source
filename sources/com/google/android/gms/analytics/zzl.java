package com.google.android.gms.analytics;
public final class zzl implements Runnable {
    private final /* synthetic */ zzg zzsw;
    private final /* synthetic */ zzk zzsx;

    public zzl(zzk zzk, zzg zzg) {
        this.zzsx = zzk;
        this.zzsw = zzg;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzsw.zzap().zza(this.zzsw);
        for (zzn zzn : this.zzsx.zzsr) {
            zzn.zza(this.zzsw);
        }
        zzk zzk = this.zzsx;
        zzk.zzb(this.zzsw);
    }
}
