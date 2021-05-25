package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
public final class zzapj implements SignalCallbacks {
    private final /* synthetic */ zzapb zzdls;

    public zzapj(zzapf zzapf, zzapb zzapb) {
        this.zzdls = zzapb;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.zzdls.onFailure(str);
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.zzdls.zzds(str);
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }
}
