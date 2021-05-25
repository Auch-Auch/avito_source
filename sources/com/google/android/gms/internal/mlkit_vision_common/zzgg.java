package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzgg {
    private static final zzgg zza = new zzgg();
    private final zzgk zzb = new zzfi();
    private final ConcurrentMap<Class<?>, zzgh<?>> zzc = new ConcurrentHashMap();

    private zzgg() {
    }

    public static zzgg zza() {
        return zza;
    }

    public final <T> zzgh<T> zza(Class<T> cls) {
        zzem.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzgh<T> zzgh = (zzgh<T>) this.zzc.get(cls);
        if (zzgh != null) {
            return zzgh;
        }
        zzgh<T> zza2 = this.zzb.zza(cls);
        zzem.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzem.zza(zza2, "schema");
        zzgh<T> zzgh2 = (zzgh<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzgh2 != null ? zzgh2 : zza2;
    }

    public final <T> zzgh<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}
