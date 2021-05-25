package com.google.android.gms.internal.ads;
public final class zzaxx implements Runnable {
    private final /* synthetic */ zzaxu zzdzk;

    public zzaxx(zzaxu zzaxu) {
        this.zzdzk = zzaxu;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdzk.thread = Thread.currentThread();
        this.zzdzk.zzuy();
    }
}
