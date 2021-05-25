package com.google.android.gms.internal.ads;
public final class zzqk implements Runnable {
    private final /* synthetic */ zzqg zzbmt;
    private final /* synthetic */ int zzbmz;
    private final /* synthetic */ long zzbna;

    public zzqk(zzqg zzqg, int i, long j) {
        this.zzbmt = zzqg;
        this.zzbmz = i;
        this.zzbna = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmt.zzbmu.zze(this.zzbmz, this.zzbna);
    }
}
