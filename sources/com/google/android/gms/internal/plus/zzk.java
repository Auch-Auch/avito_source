package com.google.android.gms.internal.plus;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zzh;
public final class zzk extends zzp {
    private final /* synthetic */ int zzaj;
    private final /* synthetic */ String zzak;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzk(zzj zzj, GoogleApiClient googleApiClient, int i, String str) {
        super(googleApiClient, null);
        this.zzaj = i;
        this.zzak = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzh zzh) throws RemoteException {
        setCancelToken(zzh.zza(this, this.zzaj, this.zzak));
    }
}
