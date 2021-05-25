package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public abstract class zzaiw extends zzgt implements zzait {
    public zzaiw() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaiy zzaiy;
        if (i == 3) {
            zzyg videoController = getVideoController();
            parcel2.writeNoException();
            zzgw.zza(parcel2, videoController);
            return true;
        } else if (i == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        } else if (i == 5) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaiy = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                if (queryLocalInterface instanceof zzaiy) {
                    zzaiy = (zzaiy) queryLocalInterface;
                } else {
                    zzaiy = new zzaja(readStrongBinder);
                }
            }
            zza(asInterface, zzaiy);
            parcel2.writeNoException();
            return true;
        } else if (i == 6) {
            zzr(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        } else if (i != 7) {
            return false;
        } else {
            zzadr zzss = zzss();
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzss);
            return true;
        }
    }
}
