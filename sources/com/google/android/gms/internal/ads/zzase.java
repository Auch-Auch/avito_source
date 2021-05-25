package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
public final class zzase extends zzgu implements zzasc {
    public zzase(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final zzary zza(zzarw zzarw) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzarw);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzary zzary = (zzary) zzgw.zza(transactAndReadException, zzary.CREATOR);
        transactAndReadException.recycle();
        return zzary;
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zzb(zzasp zzasp, zzasj zzasj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzasp);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasj);
        zza(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zzc(zzasp zzasp, zzasj zzasj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzasp);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasj);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zza(zzarw zzarw, zzash zzash) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzarw);
        zzgw.zza(obtainAndWriteInterfaceToken, zzash);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zza(zzasp zzasp, zzasj zzasj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzasp);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasj);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zza(String str, zzasj zzasj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasj);
        zza(7, obtainAndWriteInterfaceToken);
    }
}
