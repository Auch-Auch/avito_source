package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;
/* renamed from: com.google.android.gms.internal.auth-api.zzac  reason: invalid package */
public final class zzac extends zzd implements zzad {
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    @Override // com.google.android.gms.internal.p001authapi.zzad
    public final void zzc(zzab zzab, BeginSignInRequest beginSignInRequest) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzab);
        zzf.zzc(zzc, beginSignInRequest);
        zzc(1, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzad
    public final void zzc(IStatusCallback iStatusCallback, String str) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, iStatusCallback);
        zzc.writeString(str);
        zzc(2, zzc);
    }
}
