package com.google.android.gms.internal.ads;
public final class zzik implements Runnable {
    private final /* synthetic */ zzij zzaiz;
    private final /* synthetic */ zzho zzajb;

    public zzik(zzij zzij, zzho zzho) {
        this.zzaiz = zzij;
        this.zzajb = zzho;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaiz.zzaja.zzb(this.zzajb);
    }
}
