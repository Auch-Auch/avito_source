package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
public final class zzu extends zzab {
    private final /* synthetic */ Location zzco;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzu(zzq zzq, GoogleApiClient googleApiClient, Location location) {
        super(googleApiClient);
        this.zzco = location;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzaz zzaz) throws RemoteException {
        zzaz.zza(this.zzco);
        setResult((zzu) Status.RESULT_SUCCESS);
    }
}
