package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
public final class zzf extends zzj {
    private final /* synthetic */ long zzbw;
    private final /* synthetic */ PendingIntent zzbx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzf(zze zze, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zzbw = j;
        this.zzbx = pendingIntent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzaz zzaz) throws RemoteException {
        zzaz.zza(this.zzbw, this.zzbx);
        setResult((zzf) Status.RESULT_SUCCESS);
    }
}
