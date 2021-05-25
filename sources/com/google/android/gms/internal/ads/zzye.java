package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzye extends zzgt implements zzyf {
    public zzye() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzyf zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (queryLocalInterface instanceof zzyf) {
            return (zzyf) queryLocalInterface;
        }
        return new zzyh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i != 2) {
            return false;
        } else {
            String responseId = getResponseId();
            parcel2.writeNoException();
            parcel2.writeString(responseId);
        }
        return true;
    }
}
