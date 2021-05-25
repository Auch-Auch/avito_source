package com.google.android.gms.internal.gtm;
public final class zzgg implements Runnable {
    private final /* synthetic */ zzgf zzaqn;

    public zzgg(zzgf zzgf) {
        this.zzaqn = zzgf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzaqn.zzaqb.zzapx == 1 || this.zzaqn.zzaqb.zzapx == 2) {
            this.zzaqn.zzaqb.zzapx = 4;
            zzev.zzav("Container load timed out after 5000ms.");
            while (!this.zzaqn.zzaqb.zzapy.isEmpty()) {
                this.zzaqn.zzaqb.zzamv.execute((Runnable) this.zzaqn.zzaqb.zzapy.remove());
            }
        }
    }
}
