package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
public final class zzdip {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdio<T> zzdio) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzdio.zzq(t);
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
