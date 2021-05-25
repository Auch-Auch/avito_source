package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
public final class zzafh extends zzgu implements zzafi {
    public zzafh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafi
    public final void zzsq() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }
}
