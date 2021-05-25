package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdd<T> extends zzcy<T> {
    private final T zzma;

    public zzdd(T t) {
        this.zzma = t;
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdd) {
            return this.zzma.equals(((zzdd) obj).zzma);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final T get() {
        return this.zzma;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zzma.hashCode() + 1502476572;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final boolean isPresent() {
        return true;
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zzma);
        return a.s2(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }
}
