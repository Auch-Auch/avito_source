package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;
public final class zzr extends zzb implements zzo {
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wallet.internal.IOwService");
    }

    @Override // com.google.android.gms.internal.wallet.zzo
    public final void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzq zzq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, createWalletObjectsRequest);
        zzd.zza(obtainAndWriteInterfaceToken, bundle);
        zzd.zza(obtainAndWriteInterfaceToken, zzq);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.wallet.zzo
    public final void zza(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzq zzq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, isReadyToPayRequest);
        zzd.zza(obtainAndWriteInterfaceToken, bundle);
        zzd.zza(obtainAndWriteInterfaceToken, zzq);
        zza(14, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.wallet.zzo
    public final void zza(PaymentDataRequest paymentDataRequest, Bundle bundle, zzq zzq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, paymentDataRequest);
        zzd.zza(obtainAndWriteInterfaceToken, bundle);
        zzd.zza(obtainAndWriteInterfaceToken, zzq);
        zza(19, obtainAndWriteInterfaceToken);
    }
}
