package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdz<T> implements zzdv<T>, Serializable {
    @NullableDecl
    private final T zza;

    public zzdz(@NullableDecl T t) {
        this.zza = t;
    }

    @Override // java.lang.Object
    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdz) {
            return zzdo.zza(this.zza, ((zzdz) obj).zza);
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return a.s2(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }

    @Override // com.google.android.gms.internal.measurement.zzdv
    public final T zza() {
        return this.zza;
    }
}
