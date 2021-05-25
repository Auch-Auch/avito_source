package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzctr extends zzaot {
    private zzcrg<zzapa, zzcso> zzglp;
    private final /* synthetic */ zzctp zzgmx;

    private zzctr(zzctp zzctp, zzcrg<zzapa, zzcso> zzcrg) {
        this.zzgmx = zzctp;
        this.zzglp = zzcrg;
    }

    @Override // com.google.android.gms.internal.ads.zzaou
    public final void zza(zzanj zzanj) throws RemoteException {
        this.zzgmx.zzgmw = zzanj;
        ((zzcso) this.zzglp.zzglc).onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaou
    public final void zzdq(String str) throws RemoteException {
        ((zzcso) this.zzglp.zzglc).zzc(0, str);
    }
}
