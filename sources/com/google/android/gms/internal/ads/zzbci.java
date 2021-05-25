package com.google.android.gms.internal.ads;
public final class zzbci implements Runnable {
    private final /* synthetic */ zzbcc zzefd;
    private final /* synthetic */ int zzefh;
    private final /* synthetic */ int zzefi;

    public zzbci(zzbcc zzbcc, int i, int i2) {
        this.zzefd = zzbcc;
        this.zzefh = i;
        this.zzefi = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzbcc.zza(this.zzefd) != null) {
            zzbcc.zza(this.zzefd).zzk(this.zzefh, this.zzefi);
        }
    }
}
