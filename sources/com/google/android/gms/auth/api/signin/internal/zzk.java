package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
public final class zzk extends zzd {
    private final /* synthetic */ zzl zzcj;

    public zzk(zzl zzl) {
        this.zzcj = zzl;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zze(Status status) throws RemoteException {
        this.zzcj.setResult((zzl) status);
    }
}
