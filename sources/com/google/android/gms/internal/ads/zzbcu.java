package com.google.android.gms.internal.ads;
public final class zzbcu implements Runnable {
    private final /* synthetic */ zzbcr zzegd;
    private final /* synthetic */ boolean zzegg;

    public zzbcu(zzbcr zzbcr, boolean z) {
        this.zzegd = zzbcr;
        this.zzegg = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcr.zza(this.zzegd, "windowVisibilityChanged", new String[]{"isVisible", String.valueOf(this.zzegg)});
    }
}
