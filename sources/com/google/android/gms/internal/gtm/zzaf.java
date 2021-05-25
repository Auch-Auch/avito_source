package com.google.android.gms.internal.gtm;
public final class zzaf implements Runnable {
    private final /* synthetic */ int zzvv;
    private final /* synthetic */ zzae zzvw;

    public zzaf(zzae zzae, int i) {
        this.zzvw = zzae;
        this.zzvv = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzvw.zzvu.zzg(((long) this.zzvv) * 1000);
    }
}
