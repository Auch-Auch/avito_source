package com.google.android.gms.internal.ads;
public final class zzip implements Runnable {
    private final /* synthetic */ zzij zzaiz;
    private final /* synthetic */ int zzall;

    public zzip(zzij zzij, int i) {
        this.zzaiz = zzij;
        this.zzall = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaiz.zzaja.zzx(this.zzall);
    }
}
