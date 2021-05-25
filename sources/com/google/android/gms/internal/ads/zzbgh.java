package com.google.android.gms.internal.ads;
public final class zzbgh implements Runnable {
    private final /* synthetic */ zzbgf zzeow;

    public zzbgh(zzbgf zzbgf) {
        this.zzeow = zzbgf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgf.zza(this.zzeow).destroy();
    }
}
