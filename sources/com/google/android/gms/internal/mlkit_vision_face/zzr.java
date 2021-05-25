package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzr implements Iterator<Map.Entry<K, Collection<V>>> {
    private final Iterator<Map.Entry<K, Collection<V>>> zza;
    @NullableDecl
    private Collection<V> zzb;
    private final /* synthetic */ zzp zzc;

    public zzr(zzp zzp) {
        this.zzc = zzp;
        this.zza = zzp.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Collection<V>> next = this.zza.next();
        this.zzb = next.getValue();
        zzp zzp = this.zzc;
        K key = next.getKey();
        return new zzar(key, zzp.zzb.zza((zzm) key, (Collection) next.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzj.zza(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzm.zzb(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
