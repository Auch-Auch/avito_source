package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzax {
    public static <V> V zza(Map<?, V> map, @NullableDecl Object obj) {
        zzj.zza(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean zzb(Map<?, ?> map, Object obj) {
        zzj.zza(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V zzc(Map<?, V> map, Object obj) {
        zzj.zza(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }
}
