package com.google.android.gms.internal.ads;
public final class zzdr implements Runnable {
    private final /* synthetic */ zzdp zzwd;

    public zzdr(zzdp zzdp) {
        this.zzwd = zzdp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzwd.zzwb) {
            if (!(this.zzwd.zzwc)) {
                this.zzwd.zzwc = true;
            } else {
                return;
            }
        }
        try {
            this.zzwd.zzbs();
        } catch (Exception e) {
            this.zzwd.zzvw.zza(2023, -1, e);
        }
        synchronized (this.zzwd.zzwb) {
            this.zzwd.zzwc = false;
        }
    }
}
