package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
/* renamed from: com.google.android.gms.internal.auth-api.zzo  reason: invalid package */
public abstract class zzo<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzq> {
    public zzo(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public /* synthetic */ void doExecute(zzq zzq) throws RemoteException {
        zzq zzq2 = zzq;
        zzc(zzq2.getContext(), (zzx) zzq2.getService());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.auth-api.zzo<R extends com.google.android.gms.common.api.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzo<R>) ((Result) obj));
    }

    public abstract void zzc(Context context, zzx zzx) throws DeadObjectException, RemoteException;
}
