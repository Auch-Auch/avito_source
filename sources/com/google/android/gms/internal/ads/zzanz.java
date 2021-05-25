package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzanz implements Runnable {
    private final /* synthetic */ zzanx zzdlg;

    public zzanz(zzanx zzanx) {
        this.zzdlg = zzanx;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzanx.zza(this.zzdlg).onAdOpened();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}
