package com.google.android.gms.internal.ads;
public final class zzdvx implements Runnable {
    private final /* synthetic */ Runnable zzhqa;
    private final /* synthetic */ zzdvy zzhqb;

    public zzdvx(zzdvy zzdvy, Runnable runnable) {
        this.zzhqb = zzdvy;
        this.zzhqa = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhqb.zzhqc = false;
        this.zzhqa.run();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.zzhqa.toString();
    }
}
