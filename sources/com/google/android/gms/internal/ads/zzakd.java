package com.google.android.gms.internal.ads;
public final class zzakd implements Runnable {
    private final /* synthetic */ String zzdgf;
    private final /* synthetic */ zzajz zzdgg;

    public zzakd(zzajz zzajz, String str) {
        this.zzdgg = zzajz;
        this.zzdgf = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzajz.zza(this.zzdgg).loadData(this.zzdgf, "text/html", "UTF-8");
    }
}
