package com.google.android.gms.internal.ads;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzeio {
    private static final zzeio zziiu = new zzeio();
    private final zzeiy zziiv = new zzehq();
    private final ConcurrentMap<Class<?>, zzeiv<?>> zziiw = new ConcurrentHashMap();

    private zzeio() {
    }

    public static zzeio zzbhg() {
        return zziiu;
    }

    public final <T> zzeiv<T> zzaw(T t) {
        return zzh(t.getClass());
    }

    public final <T> zzeiv<T> zzh(Class<T> cls) {
        zzegr.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzeiv<T> zzeiv = (zzeiv<T>) this.zziiw.get(cls);
        if (zzeiv != null) {
            return zzeiv;
        }
        zzeiv<T> zzg = this.zziiv.zzg(cls);
        zzegr.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzegr.zza(zzg, "schema");
        zzeiv<T> zzeiv2 = (zzeiv<T>) this.zziiw.putIfAbsent(cls, zzg);
        return zzeiv2 != null ? zzeiv2 : zzg;
    }
}
