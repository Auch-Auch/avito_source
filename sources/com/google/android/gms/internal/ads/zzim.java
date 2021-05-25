package com.google.android.gms.internal.ads;
public final class zzim implements Runnable {
    private final /* synthetic */ zzij zzaiz;
    private final /* synthetic */ zzjl zzajf;

    public zzim(zzij zzij, zzjl zzjl) {
        this.zzaiz = zzij;
        this.zzajf = zzjl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajf.zzgl();
        this.zzaiz.zzaja.zzb(this.zzajf);
    }
}
