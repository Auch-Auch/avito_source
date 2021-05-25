package com.google.android.gms.internal.ads;
public final class zzmp implements Runnable {
    private final /* synthetic */ zzmn zzbeg;

    public zzmp(zzmn zzmn) {
        this.zzbeg = zzmn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!zzmn.zzb(this.zzbeg)) {
            zzmn.zzc(this.zzbeg).zza((zzna) this.zzbeg);
        }
    }
}
