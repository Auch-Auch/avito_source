package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzar<K, V> extends zzz<K, V> implements Serializable {
    @NullableDecl
    private final K zza;
    @NullableDecl
    private final V zzb;

    public zzar(@NullableDecl K k, @NullableDecl V v) {
        this.zza = k;
        this.zzb = v;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzz, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzz, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzz, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
