package com.google.android.gms.internal.ads;
public final class zzri implements Runnable {
    private final /* synthetic */ zzrf zzbsy;

    public zzri(zzrf zzrf) {
        this.zzbsy = zzrf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (zzrf.zza(this.zzbsy)) {
            if (!zzrf.zzb(this.zzbsy) || !zzrf.zzc(this.zzbsy)) {
                zzbbd.zzef("App is still foreground");
            } else {
                zzrf.zza(this.zzbsy, false);
                zzbbd.zzef("App went background");
                for (zzrh zzrh : zzrf.zzd(this.zzbsy)) {
                    try {
                        zzrh.zzp(false);
                    } catch (Exception e) {
                        zzbbd.zzc("", e);
                    }
                }
            }
        }
    }
}
