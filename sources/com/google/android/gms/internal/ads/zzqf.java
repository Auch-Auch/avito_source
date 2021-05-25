package com.google.android.gms.internal.ads;
public final class zzqf implements Runnable {
    private final /* synthetic */ zzjl zzaiy;
    private final /* synthetic */ zzqg zzbmt;

    public zzqf(zzqg zzqg, zzjl zzjl) {
        this.zzbmt = zzqg;
        this.zzaiy = zzjl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmt.zzbmu.zze(this.zzaiy);
    }
}
