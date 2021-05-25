package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
public final class zzaoe implements Runnable {
    private final /* synthetic */ zzanx zzdlg;
    private final /* synthetic */ AdRequest.ErrorCode zzdlh;

    public zzaoe(zzanx zzanx, AdRequest.ErrorCode errorCode) {
        this.zzdlg = zzanx;
        this.zzdlh = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzanx.zza(this.zzdlg).onAdFailedToLoad(zzaoj.zza(this.zzdlh));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}
