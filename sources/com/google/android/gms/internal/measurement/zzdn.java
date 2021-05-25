package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdn<T> extends zzdr<T> {
    public static final zzdn<Object> zza = new zzdn<>();

    private zzdn() {
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

    @Override // com.google.android.gms.internal.measurement.zzdr
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzdr
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
