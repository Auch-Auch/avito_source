package com.google.android.gms.common.internal;

import a2.b.a.a.a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
public final class zzn extends zzb implements zzm {
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final IObjectWrapper zzb() throws RemoteException {
        return a.F1(zza(1, a_()));
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final int zzc() throws RemoteException {
        Parcel zza = zza(2, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
