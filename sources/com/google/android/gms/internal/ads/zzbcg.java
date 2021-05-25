package com.google.android.gms.internal.ads;
public final class zzbcg implements Runnable {
    private final /* synthetic */ zzbcc zzefd;
    private final /* synthetic */ String zzeff;
    private final /* synthetic */ String zzefg;

    public zzbcg(zzbcc zzbcc, String str, String str2) {
        this.zzefd = zzbcc;
        this.zzeff = str;
        this.zzefg = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzbcc.zza(this.zzefd) != null) {
            zzbcc.zza(this.zzefd).zzm(this.zzeff, this.zzefg);
        }
    }
}
