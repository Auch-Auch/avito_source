package com.google.android.gms.internal.gtm;
public final class zzgi implements Runnable {
    private final /* synthetic */ zzgh zzaqo;

    public zzgi(zzgh zzgh) {
        this.zzaqo = zzgh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzev.zzab("App's UI deactivated. Dispatching hits.");
        this.zzaqo.zzaqb.zzaps.dispatch();
    }
}
