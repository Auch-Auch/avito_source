package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzia {
    private static final zzia zza = new zzia();
    private final zzie zzb = new zzhc();
    private final ConcurrentMap<Class<?>, zzib<?>> zzc = new ConcurrentHashMap();

    private zzia() {
    }

    public static zzia zza() {
        return zza;
    }

    public final <T> zzib<T> zza(Class<T> cls) {
        zzgg.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzib<T> zzib = (zzib<T>) this.zzc.get(cls);
        if (zzib != null) {
            return zzib;
        }
        zzib<T> zza2 = this.zzb.zza(cls);
        zzgg.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzgg.zza(zza2, "schema");
        zzib<T> zzib2 = (zzib<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzib2 != null ? zzib2 : zza2;
    }

    public final <T> zzib<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}
