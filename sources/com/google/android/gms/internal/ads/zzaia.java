package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
public final class zzaia extends zzgu implements zzahx {
    public zzaia(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzahx
    public final void zza(zzahr zzahr, zzahv zzahv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzahr);
        zzgw.zza(obtainAndWriteInterfaceToken, zzahv);
        zzb(2, obtainAndWriteInterfaceToken);
    }
}
