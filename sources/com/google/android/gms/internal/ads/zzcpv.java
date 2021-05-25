package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
public final class zzcpv implements zzdvi<ParcelFileDescriptor> {
    private final /* synthetic */ zzasj zzgjf;

    public zzcpv(zzcpj zzcpj, zzasj zzasj) {
        this.zzgjf = zzasj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.zzgjf.zzb(parcelFileDescriptor);
        } catch (RemoteException e) {
            zzaxy.zza("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        try {
            this.zzgjf.zza(zzazl.zzc(th));
        } catch (RemoteException e) {
            zzaxy.zza("Service can't call client", e);
        }
    }
}
