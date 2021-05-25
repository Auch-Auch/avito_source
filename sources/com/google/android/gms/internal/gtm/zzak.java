package com.google.android.gms.internal.gtm;
public final class zzak implements Runnable {
    private final /* synthetic */ zzae zzvw;
    private final /* synthetic */ zzbw zzwb;

    public zzak(zzae zzae, zzbw zzbw) {
        this.zzvw = zzae;
        this.zzwb = zzbw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzvw.zzvu.zzb(this.zzwb);
    }
}
