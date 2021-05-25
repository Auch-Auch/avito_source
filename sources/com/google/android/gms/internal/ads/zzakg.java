package com.google.android.gms.internal.ads;
public final class zzakg implements Runnable {
    private final /* synthetic */ String zzdgf;
    private final /* synthetic */ zzajz zzdgg;

    public zzakg(zzajz zzajz, String str) {
        this.zzdgg = zzajz;
        this.zzdgf = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzajz.zza(this.zzdgg).loadData(this.zzdgf, "text/html", "UTF-8");
    }
}
