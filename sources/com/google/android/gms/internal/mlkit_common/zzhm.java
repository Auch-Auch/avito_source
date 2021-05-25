package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzhm {
    private static final zzhm zza = new zzhm();
    private final zzhq zzb = new zzgo();
    private final ConcurrentMap<Class<?>, zzhr<?>> zzc = new ConcurrentHashMap();

    private zzhm() {
    }

    public static zzhm zza() {
        return zza;
    }

    public final <T> zzhr<T> zza(Class<T> cls) {
        zzfs.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzhr<T> zzhr = (zzhr<T>) this.zzc.get(cls);
        if (zzhr != null) {
            return zzhr;
        }
        zzhr<T> zza2 = this.zzb.zza(cls);
        zzfs.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzfs.zza(zza2, "schema");
        zzhr<T> zzhr2 = (zzhr<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzhr2 != null ? zzhr2 : zza2;
    }

    public final <T> zzhr<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}
