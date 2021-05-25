package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzac extends zzb implements zzad {
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final zzah[] zza(IObjectWrapper iObjectWrapper, zzu zzu, zzaj zzaj) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, zzu);
        zzd.zza(zza, zzaj);
        Parcel zza2 = zza(3, zza);
        zzah[] zzahArr = (zzah[]) zza2.createTypedArray(zzah.CREATOR);
        zza2.recycle();
        return zzahArr;
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final void zzs() throws RemoteException {
        zzb(2, zza());
    }
}
