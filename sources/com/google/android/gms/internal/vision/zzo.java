package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;
public final class zzo extends zzb implements zzl {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zza(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, zzu);
        Parcel zza2 = zza(1, zza);
        Barcode[] barcodeArr = (Barcode[]) zza2.createTypedArray(Barcode.CREATOR);
        zza2.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zzb(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, zzu);
        Parcel zza2 = zza(2, zza);
        Barcode[] barcodeArr = (Barcode[]) zza2.createTypedArray(Barcode.CREATOR);
        zza2.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final void zzo() throws RemoteException {
        zzb(3, zza());
    }
}
