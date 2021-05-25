package com.google.android.gms.internal.gtm;
public final class zzah implements Runnable {
    private final /* synthetic */ zzae zzvw;
    private final /* synthetic */ String zzvy;
    private final /* synthetic */ Runnable zzvz;

    public zzah(zzae zzae, String str, Runnable runnable) {
        this.zzvw = zzae;
        this.zzvy = str;
        this.zzvz = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzvw.zzvu.zzy(this.zzvy);
        Runnable runnable = this.zzvz;
        if (runnable != null) {
            runnable.run();
        }
    }
}
