package com.google.android.gms.internal.ads;
public final class zzms implements Runnable {
    private final /* synthetic */ zzmn zzbeg;
    private final /* synthetic */ zzmt zzbei;

    public zzms(zzmn zzmn, zzmt zzmt) {
        this.zzbeg = zzmn;
        this.zzbei = zzmt;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbei.release();
        int size = zzmn.zzd(this.zzbeg).size();
        for (int i = 0; i < size; i++) {
            ((zznh) zzmn.zzd(this.zzbeg).valueAt(i)).disable();
        }
    }
}
