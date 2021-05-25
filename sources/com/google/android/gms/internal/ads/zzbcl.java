package com.google.android.gms.internal.ads;
public final class zzbcl implements Runnable {
    private final /* synthetic */ zzbcc zzefd;

    public zzbcl(zzbcc zzbcc) {
        this.zzefd = zzbcc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzbcc.zza(this.zzefd) != null) {
            zzbcc.zza(this.zzefd).onPaused();
            zzbcc.zza(this.zzefd).zzzb();
        }
    }
}
