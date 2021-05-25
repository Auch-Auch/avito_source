package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
public final class zzanp implements InitializationCompleteCallback {
    private final /* synthetic */ zzaih zzdkm;

    public zzanp(zzanq zzanq, zzaih zzaih) {
        this.zzdkm = zzaih;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zzdkm.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zzdkm.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }
}
