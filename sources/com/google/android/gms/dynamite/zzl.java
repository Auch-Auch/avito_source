package com.google.android.gms.dynamite;

import a2.b.a.a.a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
public final class zzl extends zzb implements zzm {
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        zzd.zza(a_, iObjectWrapper2);
        return a.F1(zza(2, a_));
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        zzd.zza(a_, iObjectWrapper2);
        return a.F1(zza(3, a_));
    }
}
