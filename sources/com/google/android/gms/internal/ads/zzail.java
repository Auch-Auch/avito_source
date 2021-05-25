package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzail extends zzgt implements zzaim {
    public zzail() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzaim zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzaim) {
            return (zzaim) queryLocalInterface;
        }
        return new zzaio(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zze(parcel.createTypedArrayList(zzaif.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
