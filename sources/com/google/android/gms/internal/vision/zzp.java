package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzp extends zzb implements zzn {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
    }

    @Override // com.google.android.gms.internal.vision.zzn
    public final zzl zza(IObjectWrapper iObjectWrapper, zzk zzk) throws RemoteException {
        zzl zzl;
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, zzk);
        Parcel zza2 = zza(1, zza);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzl = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            if (queryLocalInterface instanceof zzl) {
                zzl = (zzl) queryLocalInterface;
            } else {
                zzl = new zzo(readStrongBinder);
            }
        }
        zza2.recycle();
        return zzl;
    }
}
