package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;
public interface zzl extends IInterface {
    Barcode[] zza(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException;

    Barcode[] zzb(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException;

    void zzo() throws RemoteException;
}
