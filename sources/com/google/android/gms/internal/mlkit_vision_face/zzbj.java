package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
public abstract class zzbj<F, T> implements Iterator<T> {
    private final Iterator<? extends F> zza;

    public zzbj(Iterator<? extends F> it) {
        this.zza = (Iterator) zzj.zza(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.mlkit_vision_face.zzbj<F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final T next() {
        return (T) zza(this.zza.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }

    public abstract T zza(F f);
}
