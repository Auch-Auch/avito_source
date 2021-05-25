package com.google.android.gms.internal.p000authapiphone;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzi  reason: invalid package */
public final class zzi extends zzb implements zzj {
    public zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzl);
        zza(1, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(String str, zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzl);
        zza(2, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iStatusCallback);
        zza(3, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(zzf zzf) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzf);
        zza(4, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(String str, zzh zzh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzh);
        zza(5, zza);
    }
}
