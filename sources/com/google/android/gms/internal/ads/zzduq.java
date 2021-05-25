package com.google.android.gms.internal.ads;
public final class zzduq implements Runnable {
    private final /* synthetic */ zzdup zzhoz;
    private final /* synthetic */ zzdtf zzhpg;

    public zzduq(zzdup zzdup, zzdtf zzdtf) {
        this.zzhoz = zzdup;
        this.zzhpg = zzdtf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhoz.zza((zzdup) this.zzhpg);
    }
}
