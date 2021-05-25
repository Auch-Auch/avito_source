package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
public class zzu implements Iterator<V> {
    public final Iterator<V> zza;
    private final Collection<V> zzb;
    private final /* synthetic */ zzv zzc;

    public zzu(zzv zzv) {
        this.zzc = zzv;
        Collection<V> collection = zzv.zzb;
        this.zzb = collection;
        this.zza = zzm.zzb(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.zza.remove();
        zzm.zzb(this.zzc.zzd);
        this.zzc.zzb();
    }

    public final void zza() {
        this.zzc.zza();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public zzu(zzv zzv, Iterator<V> it) {
        this.zzc = zzv;
        this.zzb = zzv.zzb;
        this.zza = it;
    }
}
