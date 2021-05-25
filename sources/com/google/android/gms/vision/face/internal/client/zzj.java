package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;
public final class zzj extends zzb implements zzh {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, iObjectWrapper2);
        zzd.zza(zza, iObjectWrapper3);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(i4);
        zza.writeInt(i5);
        zza.writeInt(i6);
        zzd.zza(zza, zzu);
        Parcel zza2 = zza(4, zza);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza2.createTypedArray(FaceParcel.CREATOR);
        zza2.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, zzu);
        Parcel zza2 = zza(1, zza);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza2.createTypedArray(FaceParcel.CREATOR);
        zza2.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zzd(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        Parcel zza2 = zza(2, zza);
        boolean zza3 = zzd.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zzo() throws RemoteException {
        zzb(3, zza());
    }
}
