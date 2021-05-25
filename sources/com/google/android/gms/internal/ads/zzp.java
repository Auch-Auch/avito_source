package com.google.android.gms.internal.ads;
public final class zzp implements Runnable {
    private final /* synthetic */ zzaa zzaa;
    private final /* synthetic */ zzm zzab;

    public zzp(zzm zzm, zzaa zzaa2) {
        this.zzab = zzm;
        this.zzaa = zzaa2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzab.zzm.put(this.zzaa);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
