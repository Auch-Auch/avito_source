package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzzi extends zzwp {
    public final /* synthetic */ zzzg zzckk;

    private zzzi(zzzg zzzg) {
        this.zzckk = zzzg;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zza(zzvc zzvc, int i) throws RemoteException {
        zzbbd.zzfc("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbat.zzaah.post(new zzzh(this));
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zzb(zzvc zzvc) throws RemoteException {
        zza(zzvc, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final String zzkf() throws RemoteException {
        return null;
    }
}
