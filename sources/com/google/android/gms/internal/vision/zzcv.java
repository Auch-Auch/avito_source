package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzcv<T> extends zzcy<T> {
    public static final zzcv<Object> zzly = new zzcv<>();

    private zzcv() {
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final boolean isPresent() {
        return false;
    }

    @Override // java.lang.Object
    public final String toString() {
        return "Optional.absent()";
    }
}
