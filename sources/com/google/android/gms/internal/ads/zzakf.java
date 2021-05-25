package com.google.android.gms.internal.ads;
public final class zzakf implements Runnable {
    private final /* synthetic */ zzajz zzdgg;
    private final /* synthetic */ String zzdgi;

    public zzakf(zzajz zzajz, String str) {
        this.zzdgg = zzajz;
        this.zzdgi = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzajz.zza(this.zzdgg).loadUrl(this.zzdgi);
    }
}
