package com.google.android.gms.internal.ads;
public final class zzbcv implements Runnable {
    private final /* synthetic */ zzbcr zzegd;

    public zzbcv(zzbcr zzbcr) {
        this.zzegd = zzbcr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcr.zza(this.zzegd, "surfaceDestroyed", new String[0]);
    }
}
