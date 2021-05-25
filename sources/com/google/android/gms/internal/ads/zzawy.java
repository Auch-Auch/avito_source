package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
public abstract class zzawy extends zzgt implements zzawz {
    public static zzawz zzar(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        if (queryLocalInterface instanceof zzawz) {
            return (zzawz) queryLocalInterface;
        }
        return new zzaxb(iBinder);
    }
}
