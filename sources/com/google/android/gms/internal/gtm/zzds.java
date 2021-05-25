package com.google.android.gms.internal.gtm;
public final class zzds implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    public zzds(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdq.zzc(this.zzanc).execute(new zzdw(this.zzanc, null));
    }
}
