package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
public final class zzaib extends zzahy {
    private final /* synthetic */ zzbbq zzbvn;

    public zzaib(zzaic zzaic, zzbbq zzbbq) {
        this.zzbvn = zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbvn.set(parcelFileDescriptor);
    }
}
