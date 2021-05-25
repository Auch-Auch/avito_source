package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzac {
    public static boolean zza(Collection<?> collection, @NullableDecl Object obj) {
        zzj.zza(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
