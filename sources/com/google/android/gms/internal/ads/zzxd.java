package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
public final class zzxd extends zzgu implements zzxb {
    public zzxd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void onAdMetadataChanged() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
