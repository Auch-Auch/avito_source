package com.google.android.gms.internal.wallet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.Wallet;
public final class zzac extends Wallet.zzb {
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ CreateWalletObjectsRequest zzeh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzac(zzaa zzaa, GoogleApiClient googleApiClient, CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        super(googleApiClient);
        this.zzeh = createWalletObjectsRequest;
        this.val$requestCode = i;
    }

    @Override // com.google.android.gms.wallet.Wallet.zza
    /* renamed from: zza */
    public final void doExecute(zzv zzv) {
        zzv.zza(this.zzeh, this.val$requestCode);
        setResult((zzac) Status.RESULT_SUCCESS);
    }
}
