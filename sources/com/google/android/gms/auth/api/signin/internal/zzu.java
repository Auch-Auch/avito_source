package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p001authapi.zzd;
import com.google.android.gms.internal.p001authapi.zzf;
public final class zzu extends zzd implements zzv {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zzc(zzt zzt, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzt);
        zzf.zzc(zzc, googleSignInOptions);
        zzc(101, zzc);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zzd(zzt zzt, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzt);
        zzf.zzc(zzc, googleSignInOptions);
        zzc(102, zzc);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zze(zzt zzt, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzt);
        zzf.zzc(zzc, googleSignInOptions);
        zzc(103, zzc);
    }
}
