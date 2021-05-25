package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;
public interface zzo extends IInterface {
    void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzq zzq) throws RemoteException;

    void zza(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzq zzq) throws RemoteException;

    void zza(PaymentDataRequest paymentDataRequest, Bundle bundle, zzq zzq) throws RemoteException;
}
