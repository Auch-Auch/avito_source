package com.google.android.gms.internal.ads;
public final class zzbcs implements Runnable {
    private final /* synthetic */ zzbcr zzegd;

    public zzbcs(zzbcr zzbcr) {
        this.zzegd = zzbcr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcr.zza(this.zzegd, "surfaceCreated", new String[0]);
    }
}
