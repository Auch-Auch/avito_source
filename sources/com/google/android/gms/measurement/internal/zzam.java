package com.google.android.gms.measurement.internal;

import java.util.Iterator;
public final class zzam implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzan zzb;

    public zzam(zzan zzan) {
        this.zzb = zzan;
        this.zza = zzan.zza.keySet().iterator();
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
        throw new UnsupportedOperationException("Remove not supported");
    }
}
