package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
public final class zzja implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zziy zzb;

    public zzja(zziy zziy) {
        this.zzb = zziy;
        this.zza = zziy.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
