package com.google.android.gms.internal.ads;
public final class zzqh implements Runnable {
    private final /* synthetic */ zzho zzajb;
    private final /* synthetic */ zzqg zzbmt;

    public zzqh(zzqg zzqg, zzho zzho) {
        this.zzbmt = zzqg;
        this.zzajb = zzho;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmt.zzbmu.zzk(this.zzajb);
    }
}
