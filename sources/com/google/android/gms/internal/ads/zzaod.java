package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzaod implements Runnable {
    private final /* synthetic */ zzanx zzdlg;

    public zzaod(zzanx zzanx) {
        this.zzdlg = zzanx;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzanx.zza(this.zzdlg).onAdLeftApplication();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}
