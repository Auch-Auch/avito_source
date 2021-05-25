package com.google.android.gms.internal.gtm;
public final class zzgo implements Runnable {
    private final /* synthetic */ zzgl zzaqv;

    public zzgo(zzgl zzgl) {
        this.zzaqv = zzgl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzgl.zza(this.zzaqv).isEmpty()) {
            zzev.zzac("TagManagerBackend dispatch called without loaded container.");
            return;
        }
        for (zzdq zzdq : zzgl.zza(this.zzaqv).values()) {
            zzdq.dispatch();
        }
    }
}
