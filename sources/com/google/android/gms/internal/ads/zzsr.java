package com.google.android.gms.internal.ads;
public final class zzsr implements Runnable {
    private final /* synthetic */ zzss zzbuu;

    public zzsr(zzss zzss) {
        this.zzbuu = zzss;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbuu.disconnect();
    }
}
