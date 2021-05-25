package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
public abstract class zzadn extends zzgt implements zzado {
    public zzadn() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzado zzm(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzado) {
            return (zzado) queryLocalInterface;
        }
        return new zzadq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            String text = getText();
            parcel2.writeNoException();
            parcel2.writeString(text);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            List<zzadw> zzry = zzry();
            parcel2.writeNoException();
            parcel2.writeList(zzry);
            return true;
        }
    }
}
