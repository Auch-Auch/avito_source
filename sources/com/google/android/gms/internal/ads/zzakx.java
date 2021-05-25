package com.google.android.gms.internal.ads;
public final class zzakx extends zzbbx<zzali> {
    private final Object lock = new Object();
    private final zzalb zzdhd;
    private boolean zzdhe;

    public zzakx(zzalb zzalb) {
        this.zzdhd = zzalb;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzdhe) {
                this.zzdhe = true;
                zza(new zzala(this), new zzbbv());
                zza(new zzakz(this), new zzalc(this));
            }
        }
    }
}
