package com.google.android.gms.internal.measurement;

import java.util.Iterator;
public final class zzkx implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzkv zzb;

    public zzkx(zzkv zzkv) {
        this.zzb = zzkv;
        this.zza = zzkv.zza.iterator();
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
