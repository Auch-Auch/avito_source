package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzyd extends zzgt implements zzya {
    public zzyd() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzya zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzya) {
            return (zzya) queryLocalInterface;
        }
        return new zzyc(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((zzvl) zzgw.zza(parcel, zzvl.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
