package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
public final class zzg extends zzj {
    private final /* synthetic */ PendingIntent zzbx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzg(zze zze, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zzbx = pendingIntent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzaz zzaz) throws RemoteException {
        zzaz.zzb(this.zzbx);
        setResult((zzg) Status.RESULT_SUCCESS);
    }
}
