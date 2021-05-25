package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
public abstract class zzbic extends zzgt implements zzbid {
    public static zzbid zzas(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (queryLocalInterface instanceof zzbid) {
            return (zzbid) queryLocalInterface;
        }
        return new zzbie(iBinder);
    }
}
