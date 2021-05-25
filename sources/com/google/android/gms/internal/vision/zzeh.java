package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class zzeh<K, V> extends zzdn<K, V> implements Serializable {
    private final transient int size;
    private final transient zzef<K, ? extends zzeb<V>> zznc;

    public zzeh(zzef<K, ? extends zzeb<V>> zzef, int i) {
        this.zznc = zzef;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    public final boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzdo, java.lang.Object
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzdo, java.lang.Object
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzdo, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzdo, com.google.android.gms.internal.vision.zzen
    public final /* synthetic */ Map zzcc() {
        return this.zznc;
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    public final Map<K, Collection<V>> zzcd() {
        throw new AssertionError("should never be called");
    }
}
