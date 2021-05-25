package com.google.android.gms.internal.mlkit_vision_face;

import a2.b.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzi<T> extends zzg<T> {
    private final T zza;

    public zzi(T t) {
        this.zza = t;
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzi) {
            return this.zza.equals(((zzi) obj).zza);
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return a.s2(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzg
    public final T zza(T t) {
        zzj.zza(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzg
    public final boolean zza() {
        return true;
    }
}
