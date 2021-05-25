package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
public final class zzt extends zzab {
    private final /* synthetic */ boolean zzcn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzt(zzq zzq, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient);
        this.zzcn = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzaz zzaz) throws RemoteException {
        zzaz.zza(this.zzcn);
        setResult((zzt) Status.RESULT_SUCCESS);
    }
}
