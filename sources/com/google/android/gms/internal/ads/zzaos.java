package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzaos extends zzgt implements zzaop {
    public zzaos() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzuh();
        } else if (i != 3) {
            return false;
        } else {
            zzdq(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
