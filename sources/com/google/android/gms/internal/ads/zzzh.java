package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzzh implements Runnable {
    private final /* synthetic */ zzzi zzckj;

    public zzzh(zzzi zzzi) {
        this.zzckj = zzzi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzckj.zzckk.zzbpf != null) {
            try {
                this.zzckj.zzckk.zzbpf.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbbd.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
