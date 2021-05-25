package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
/* renamed from: com.google.android.gms.internal.auth-api.zzn  reason: invalid package */
public final class zzn extends zzo<Status> {
    private final /* synthetic */ Credential zzao;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzn(zzj zzj, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zzao = credential;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.internal.p001authapi.zzo
    public final void zzc(Context context, zzx zzx) throws RemoteException {
        zzx.zzc(new zzp(this), new zzt(this.zzao));
    }
}
