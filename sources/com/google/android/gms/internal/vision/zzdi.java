package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdi {
    public static <T> zzdf<T> zza(zzdf<T> zzdf) {
        if ((zzdf instanceof zzdk) || (zzdf instanceof zzdh)) {
            return zzdf;
        }
        if (zzdf instanceof Serializable) {
            return new zzdh(zzdf);
        }
        return new zzdk(zzdf);
    }

    public static <T> zzdf<T> zzd(@NullableDecl T t) {
        return new zzdj(t);
    }
}
