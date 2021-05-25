package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
public abstract class zzdpw extends zzgt implements zzdpt {
    public static zzdpt zzat(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (queryLocalInterface instanceof zzdpt) {
            return (zzdpt) queryLocalInterface;
        }
        return new zzdpv(iBinder);
    }
}
