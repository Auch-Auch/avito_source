package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
public final class zzbvc implements Runnable {
    private final WeakReference<zzbvb> zzftd;

    private zzbvc(zzbvb zzbvb) {
        this.zzftd = new WeakReference<>(zzbvb);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbvb zzbvb = this.zzftd.get();
        if (zzbvb != null) {
            zzbvb.zzajo();
        }
    }
}
