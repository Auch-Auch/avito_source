package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdui;
public final class zzdwb extends zzdui.zzj<Void> implements Runnable {
    private final Runnable zzhqh;

    public zzdwb(Runnable runnable) {
        this.zzhqh = (Runnable) zzdsv.checkNotNull(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzhqh.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdsy.zzi(th);
        }
    }
}
