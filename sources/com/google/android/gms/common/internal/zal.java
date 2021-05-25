package com.google.android.gms.common.internal;

import a2.b.a.a.a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;
public final class zal extends zab implements zam {
    public zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.zam
    public final IObjectWrapper zaa(IObjectWrapper iObjectWrapper, zau zau) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, iObjectWrapper);
        zad.zaa(zaa, zau);
        return a.F1(zaa(2, zaa));
    }
}
