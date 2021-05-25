package com.google.android.gms.internal.ads;
public final class zzfb implements Runnable {
    private final /* synthetic */ zzex zzzk;

    public zzfb(zzex zzex) {
        this.zzzk = zzex;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaat.initialize(this.zzzk.zzvr);
    }
}
