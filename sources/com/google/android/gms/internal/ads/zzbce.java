package com.google.android.gms.internal.ads;
public final class zzbce implements Runnable {
    private final /* synthetic */ zzbcc zzefd;

    public zzbce(zzbcc zzbcc) {
        this.zzefd = zzbcc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzbcc.zza(this.zzefd) != null) {
            zzbcc.zza(this.zzefd).zzez();
        }
    }
}
