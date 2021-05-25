package com.google.android.gms.internal.gtm;
public final class zzgn implements Runnable {
    private final /* synthetic */ zzgl zzaqv;
    private final /* synthetic */ zzee zzaqw;

    public zzgn(zzgl zzgl, zzee zzee) {
        this.zzaqv = zzgl;
        this.zzaqw = zzee;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzgl.zza(this.zzaqv).isEmpty()) {
            zzev.zzav("TagManagerBackend emit called without loaded container.");
            return;
        }
        for (zzdq zzdq : zzgl.zza(this.zzaqv).values()) {
            zzdq.zza(this.zzaqw);
        }
    }
}
