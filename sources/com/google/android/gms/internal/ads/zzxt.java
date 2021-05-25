package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
public final class zzxt extends zzgu implements zzxr {
    public zzxt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdMuted() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
