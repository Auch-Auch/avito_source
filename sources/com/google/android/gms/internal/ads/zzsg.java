package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzsg extends zzgt implements zzsd {
    public zzsg() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzsj zzsj;
        if (i == 2) {
            zzwu zzdu = zzdu();
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzdu);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzsj = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                if (queryLocalInterface instanceof zzsj) {
                    zzsj = (zzsj) queryLocalInterface;
                } else {
                    zzsj = new zzsl(readStrongBinder);
                }
            }
            zza(zzsj);
            parcel2.writeNoException();
            return true;
        }
    }
}
