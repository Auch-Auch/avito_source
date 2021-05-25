package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
public final class zzwi extends zzgu implements zzwg {
    public zzwi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzwg
    public final void onAdClicked() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
