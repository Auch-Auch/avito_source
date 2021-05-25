package com.google.android.gms.internal.ads;
public final class zzil implements Runnable {
    private final /* synthetic */ zzij zzaiz;
    private final /* synthetic */ String zzajc;
    private final /* synthetic */ long zzajd;
    private final /* synthetic */ long zzaje;

    public zzil(zzij zzij, String str, long j, long j2) {
        this.zzaiz = zzij;
        this.zzajc = str;
        this.zzajd = j;
        this.zzaje = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaiz.zzaja.zza(this.zzajc, this.zzajd, this.zzaje);
    }
}
