package com.google.android.gms.internal.mlkit_vision_face;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzb<T> extends zzg<T> {
    public static final zzb<Object> zza = new zzb<>();

    private zzb() {
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return 2040732332;
    }

    @Override // java.lang.Object
    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzg
    public final T zza(T t) {
        return (T) zzj.zza(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzg
    public final boolean zza() {
        return false;
    }
}
