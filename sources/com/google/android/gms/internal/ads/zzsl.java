package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
public final class zzsl extends zzgu implements zzsj {
    public zzsl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final void onAppOpenAdClosed() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
