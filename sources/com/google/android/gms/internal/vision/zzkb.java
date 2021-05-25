package com.google.android.gms.internal.vision;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzkb {
    private static final zzkb zzabh = new zzkb();
    private final zzke zzabi = new zzja();
    private final ConcurrentMap<Class<?>, zzkf<?>> zzabj = new ConcurrentHashMap();

    private zzkb() {
    }

    public static zzkb zzik() {
        return zzabh;
    }

    public final <T> zzkf<T> zzf(Class<T> cls) {
        zzie.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzkf<T> zzkf = (zzkf<T>) this.zzabj.get(cls);
        if (zzkf != null) {
            return zzkf;
        }
        zzkf<T> zze = this.zzabi.zze(cls);
        zzie.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzie.zza(zze, "schema");
        zzkf<T> zzkf2 = (zzkf<T>) this.zzabj.putIfAbsent(cls, zze);
        return zzkf2 != null ? zzkf2 : zze;
    }

    public final <T> zzkf<T> zzx(T t) {
        return zzf(t.getClass());
    }
}
