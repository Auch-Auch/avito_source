package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzjy {
    private static final zzjy zza = new zzjy();
    private final zzkb zzb = new zzja();
    private final ConcurrentMap<Class<?>, zzkc<?>> zzc = new ConcurrentHashMap();

    private zzjy() {
    }

    public static zzjy zza() {
        return zza;
    }

    public final <T> zzkc<T> zza(Class<T> cls) {
        zzie.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzkc<T> zzkc = (zzkc<T>) this.zzc.get(cls);
        if (zzkc != null) {
            return zzkc;
        }
        zzkc<T> zza2 = this.zzb.zza(cls);
        zzie.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzie.zza(zza2, "schema");
        zzkc<T> zzkc2 = (zzkc<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzkc2 != null ? zzkc2 : zza2;
    }

    public final <T> zzkc<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}
