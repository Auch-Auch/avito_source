package com.google.android.gms.internal.ads;
public final class zzduo implements Runnable {
    private final /* synthetic */ zzdvt zzhox;
    private final /* synthetic */ int zzhoy;
    private final /* synthetic */ zzdup zzhoz;

    public zzduo(zzdup zzdup, zzdvt zzdvt, int i) {
        this.zzhoz = zzdup;
        this.zzhox = zzdvt;
        this.zzhoy = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdtf zzdtf = null;
        try {
            if (this.zzhox.isCancelled()) {
                zzdup.zza(this.zzhoz, (zzdtf) null);
                this.zzhoz.cancel(false);
            } else {
                this.zzhoz.zza((zzdup) this.zzhoy, (int) this.zzhox);
            }
        } finally {
            this.zzhoz.zza((zzdup) zzdtf);
        }
    }
}
