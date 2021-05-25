package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.internal.identity.zze;
public final class zzb extends Address.zza {
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ UserAddressRequest zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzb(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
        super(googleApiClient);
        this.zze = userAddressRequest;
        this.val$requestCode = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zze zze2) throws RemoteException {
        zze2.zza(this.zze, this.val$requestCode);
        setResult((zzb) Status.RESULT_SUCCESS);
    }
}
