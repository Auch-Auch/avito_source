package com.google.android.gms.internal.ads;

import java.io.IOException;
public final class zzmr implements Runnable {
    private final /* synthetic */ zzmn zzbeg;
    private final /* synthetic */ IOException zzbeh;

    public zzmr(zzmn zzmn, IOException iOException) {
        this.zzbeg = zzmn;
        this.zzbeh = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmn.zze(this.zzbeg).zzb(this.zzbeh);
    }
}
