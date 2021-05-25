package com.google.android.gms.internal.gtm;
public final class zzgf implements Runnable {
    public final /* synthetic */ zzfy zzaqb;

    public zzgf(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaqb.zzamv.execute(new zzgg(this));
    }
}
