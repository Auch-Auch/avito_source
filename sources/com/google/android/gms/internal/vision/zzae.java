package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzae extends zzb implements zzaf {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.vision.zzaf
    public final zzad zza(IObjectWrapper iObjectWrapper, zzam zzam) throws RemoteException {
        zzad zzad;
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, zzam);
        Parcel zza2 = zza(1, zza);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzad = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            if (queryLocalInterface instanceof zzad) {
                zzad = (zzad) queryLocalInterface;
            } else {
                zzad = new zzac(readStrongBinder);
            }
        }
        zza2.recycle();
        return zzad;
    }
}
