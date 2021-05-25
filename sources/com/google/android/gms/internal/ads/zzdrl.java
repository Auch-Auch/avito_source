package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
public final class zzdrl extends zzgu implements zzdrm {
    public zzdrl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final zzdrk zza(zzdri zzdri) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzdri);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzdrk zzdrk = (zzdrk) zzgw.zza(transactAndReadException, zzdrk.CREATOR);
        transactAndReadException.recycle();
        return zzdrk;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final void zza(zzdrd zzdrd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzdrd);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final zzdru zza(zzdrs zzdrs) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzdrs);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        zzdru zzdru = (zzdru) zzgw.zza(transactAndReadException, zzdru.CREATOR);
        transactAndReadException.recycle();
        return zzdru;
    }
}
