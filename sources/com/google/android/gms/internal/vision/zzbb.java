package com.google.android.gms.internal.vision;

import android.os.Binder;
public final /* synthetic */ class zzbb {
    public static <V> V zza(zzba<V> zzba) {
        long clearCallingIdentity;
        try {
            return zzba.zzac();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzac = zzba.zzac();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzac;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
