package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzzr implements Runnable {
    private final /* synthetic */ zzzs zzckp;

    public zzzr(zzzs zzzs) {
        this.zzckp = zzzs;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzckp.zzckq != null) {
            try {
                this.zzckp.zzckq.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbbd.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
