package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzn<K, V> extends zzm<K, V> implements zzau<K, V> {
    public zzn(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzm
    public final Collection<V> zza(K k, Collection<V> collection) {
        return zza(k, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzau
    public List<V> zzb(@NullableDecl K k) {
        return (List) super.zza((zzn<K, V>) k);
    }

    /* renamed from: zze */
    public abstract List<V> zza();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_face.zzm, com.google.android.gms.internal.mlkit_vision_face.zzbc
    public /* synthetic */ Collection zza(@NullableDecl Object obj) {
        return zzb((zzn<K, V>) obj);
    }
}
