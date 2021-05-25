package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdj<T> implements zzdf<T>, Serializable {
    @NullableDecl
    private final T zzmd;

    public zzdj(@NullableDecl T t) {
        this.zzmd = t;
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdj) {
            return zzcz.equal(this.zzmd, ((zzdj) obj).zzmd);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzdf
    public final T get() {
        return this.zzmd;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzmd});
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zzmd);
        return a.s2(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }
}
