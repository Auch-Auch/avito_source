package com.google.android.gms.internal.maps;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzg extends zza implements zze {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zza(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        return a.F1(zza(1, zza));
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return a.F1(zza(3, zza));
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return a.F1(zza(7, zza));
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zzi() throws RemoteException {
        return a.F1(zza(4, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zza(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return a.F1(zza(2, zza));
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zza(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        return a.F1(zza(5, zza));
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final IObjectWrapper zza(Bitmap bitmap) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bitmap);
        return a.F1(zza(6, zza));
    }
}
