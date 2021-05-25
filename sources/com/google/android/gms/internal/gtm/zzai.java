package com.google.android.gms.internal.gtm;
public final class zzai implements Runnable {
    private final /* synthetic */ zzae zzvw;
    private final /* synthetic */ zzcd zzwa;

    public zzai(zzae zzae, zzcd zzcd) {
        this.zzvw = zzae;
        this.zzwa = zzcd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzvw.zzvu.zza(this.zzwa);
    }
}
