package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class zzew<K, V> extends zzed<K, V> implements Serializable {
    private final transient zzeu<K, ? extends zzer<V>> zza;
    private final transient int zzb;

    public zzew(zzeu<K, ? extends zzer<V>> zzeu, int i) {
        this.zza = zzeu;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzea, java.lang.Object
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzea, java.lang.Object
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzea, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.measurement.zzea, com.google.android.gms.internal.measurement.zzfg
    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
