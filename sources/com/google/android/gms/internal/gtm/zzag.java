package com.google.android.gms.internal.gtm;
public final class zzag implements Runnable {
    private final /* synthetic */ zzae zzvw;
    private final /* synthetic */ boolean zzvx;

    public zzag(zzae zzae, boolean z) {
        this.zzvw = zzae;
        this.zzvx = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzvw.zzvu.zzec();
    }
}
