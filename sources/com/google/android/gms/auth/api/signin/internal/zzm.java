package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
public final class zzm extends zzd {
    private final /* synthetic */ zzn zzck;

    public zzm(zzn zzn) {
        this.zzck = zzn;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzf(Status status) throws RemoteException {
        this.zzck.setResult((zzn) status);
    }
}
