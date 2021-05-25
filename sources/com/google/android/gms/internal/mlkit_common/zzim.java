package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
public final class zzim implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzik zzb;

    public zzim(zzik zzik) {
        this.zzb = zzik;
        this.zza = zzik.zza.iterator();
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
