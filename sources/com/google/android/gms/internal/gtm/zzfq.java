package com.google.android.gms.internal.gtm;
public final class zzfq implements Runnable {
    private final /* synthetic */ zzfo zzapm;

    public zzfq(zzfo zzfo) {
        this.zzapm = zzfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzapm.zzapi = false;
        this.zzapm.zzapg.dispatch();
    }
}
