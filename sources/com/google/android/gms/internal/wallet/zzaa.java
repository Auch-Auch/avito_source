package com.google.android.gms.internal.wallet;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.wobs.WalletObjects;
public final class zzaa implements WalletObjects {
    @Override // com.google.android.gms.wallet.wobs.WalletObjects
    @SuppressLint({"MissingRemoteException"})
    public final void createWalletObjects(GoogleApiClient googleApiClient, CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        googleApiClient.enqueue(new zzac(this, googleApiClient, createWalletObjectsRequest, i));
    }
}
