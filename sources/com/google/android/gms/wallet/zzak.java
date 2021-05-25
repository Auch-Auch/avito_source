package com.google.android.gms.wallet;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.wallet.zzv;
import com.google.android.gms.tasks.TaskCompletionSource;
public final class zzak extends TaskApiCall<zzv, AutoResolvableVoidResult> {
    private final /* synthetic */ CreateWalletObjectsRequest zzeh;

    public zzak(WalletObjectsClient walletObjectsClient, CreateWalletObjectsRequest createWalletObjectsRequest) {
        this.zzeh = createWalletObjectsRequest;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzv zzv, TaskCompletionSource<AutoResolvableVoidResult> taskCompletionSource) throws RemoteException {
        zzv.zza(this.zzeh, taskCompletionSource);
    }
}
