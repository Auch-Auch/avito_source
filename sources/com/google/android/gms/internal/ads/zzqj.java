package com.google.android.gms.internal.ads;
public final class zzqj implements Runnable {
    private final /* synthetic */ zzqg zzbmt;
    private final /* synthetic */ int zzbmv;
    private final /* synthetic */ int zzbmw;
    private final /* synthetic */ int zzbmx;
    private final /* synthetic */ float zzbmy;

    public zzqj(zzqg zzqg, int i, int i2, int i3, float f) {
        this.zzbmt = zzqg;
        this.zzbmv = i;
        this.zzbmw = i2;
        this.zzbmx = i3;
        this.zzbmy = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmt.zzbmu.zza(this.zzbmv, this.zzbmw, this.zzbmx, this.zzbmy);
    }
}
