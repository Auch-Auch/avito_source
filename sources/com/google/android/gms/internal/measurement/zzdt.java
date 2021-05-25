package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdt<T> extends zzdr<T> {
    private final T zza;

    public zzdt(T t) {
        this.zza = t;
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdt) {
            return this.zza.equals(((zzdt) obj).zza);
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

    @Override // com.google.android.gms.internal.measurement.zzdr
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzdr
    public final T zzb() {
        return this.zza;
    }
}
