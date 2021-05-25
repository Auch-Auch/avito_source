package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzt implements Iterator<K> {
    @NullableDecl
    private Map.Entry<K, Collection<V>> zza;
    private final /* synthetic */ Iterator zzb;
    private final /* synthetic */ zzq zzc;

    public zzt(zzq zzq, Iterator it) {
        this.zzc = zzq;
        this.zzb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final K next() {
        Map.Entry<K, Collection<V>> entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzj.zza(this.zza != null, "no calls to next() since the last call to remove()");
        Collection<V> value = this.zza.getValue();
        this.zzb.remove();
        zzm.zzb(this.zzc.zza, value.size());
        value.clear();
        this.zza = null;
    }
}
