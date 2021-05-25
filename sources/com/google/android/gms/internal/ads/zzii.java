package com.google.android.gms.internal.ads;
public final class zzii implements Runnable {
    private final /* synthetic */ zzjl zzaiy;
    private final /* synthetic */ zzij zzaiz;

    public zzii(zzij zzij, zzjl zzjl) {
        this.zzaiz = zzij;
        this.zzaiy = zzjl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaiz.zzaja.zza(this.zzaiy);
    }
}
