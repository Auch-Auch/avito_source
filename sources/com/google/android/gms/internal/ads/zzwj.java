package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzwj extends zzgt implements zzwg {
    public zzwj() {
        super("com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        onAdClicked();
        parcel2.writeNoException();
        return true;
    }
}
