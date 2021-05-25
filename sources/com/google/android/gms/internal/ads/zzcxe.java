package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
public final class zzcxe extends zzwp {
    private final zzcxu zzgqe;

    public zzcxe(Context context, zzbii zzbii, zzdlp zzdlp, zzcdg zzcdg, zzwl zzwl) {
        zzcxw zzcxw = new zzcxw(zzcdg);
        zzcxw.zzc(zzwl);
        this.zzgqe = new zzcxu(new zzcyc(zzbii, context, zzcxw, zzdlp), zzdlp.zzass());
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final synchronized String getMediationAdapterClassName() {
        return this.zzgqe.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgqe.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final synchronized void zza(zzvc zzvc, int i) throws RemoteException {
        this.zzgqe.zza(zzvc, i);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zzb(zzvc zzvc) throws RemoteException {
        this.zzgqe.zza(zzvc, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final synchronized String zzkf() {
        return this.zzgqe.zzkf();
    }
}
