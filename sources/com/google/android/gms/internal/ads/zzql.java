package com.google.android.gms.internal.ads;
public final class zzql implements Runnable {
    private final /* synthetic */ zzjl zzajf;
    private final /* synthetic */ zzqg zzbmt;

    public zzql(zzqg zzqg, zzjl zzjl) {
        this.zzbmt = zzqg;
        this.zzajf = zzjl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajf.zzgl();
        this.zzbmt.zzbmu.zzf(this.zzajf);
    }
}
