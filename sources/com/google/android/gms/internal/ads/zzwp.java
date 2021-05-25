package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzwp extends zzgt implements zzwm {
    public zzwp() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzvc) zzgw.zza(parcel, zzvc.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 3) {
            boolean isLoading = isLoading();
            parcel2.writeNoException();
            zzgw.writeBoolean(parcel2, isLoading);
        } else if (i == 4) {
            String zzkf = zzkf();
            parcel2.writeNoException();
            parcel2.writeString(zzkf);
        } else if (i != 5) {
            return false;
        } else {
            zza((zzvc) zzgw.zza(parcel, zzvc.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
