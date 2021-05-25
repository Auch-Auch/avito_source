package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zzcte extends zzaos {
    private zzcrg<zzapa, zzcso> zzglp;

    private zzcte(zzctc zzctc, zzcrg<zzapa, zzcso> zzcrg) {
        this.zzglp = zzcrg;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzdq(String str) throws RemoteException {
        ((zzcso) this.zzglp.zzglc).zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzuh() throws RemoteException {
        ((zzcso) this.zzglp.zzglc).onAdLoaded();
    }
}
