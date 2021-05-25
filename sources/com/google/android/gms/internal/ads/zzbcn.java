package com.google.android.gms.internal.ads;
public final class zzbcn implements Runnable {
    private final /* synthetic */ zzbcc zzefd;

    public zzbcn(zzbcc zzbcc) {
        this.zzefd = zzbcc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzbcc.zza(this.zzefd) != null) {
            zzbcc.zza(this.zzefd).onPaused();
        }
    }
}
