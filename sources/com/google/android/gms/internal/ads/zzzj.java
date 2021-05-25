package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzzj implements Runnable {
    private final /* synthetic */ zzzk zzckl;

    public zzzj(zzzk zzzk) {
        this.zzckl = zzzk;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzckl.zzbpf != null) {
            try {
                this.zzckl.zzbpf.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbbd.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
